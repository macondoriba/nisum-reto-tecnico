package com.nisum.reto.application.service;

import com.nisum.reto.application.helper.UnprocessableEntity;
import com.nisum.reto.application.mapper.UserResponseMapper;
import com.nisum.reto.application.mapper.UserRequestMapper;
import com.nisum.reto.application.usecases.UserUseCase;

import com.nisum.reto.domain.model.dto.request.UserRequest;
import com.nisum.reto.domain.model.dto.response.UserResponse;
import com.nisum.reto.domain.port.UserPersistencePort;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserUseCase {

    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper;
    private final UserPersistencePort userPersistencePort;

    public UserService(UserRequestMapper userRequestMapper,
                       UserResponseMapper userResponseMapper,
                       UserPersistencePort userPersistencePort) {
        this.userRequestMapper = userRequestMapper;
        this.userResponseMapper = userResponseMapper;
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public UserResponse createNew(UserRequest request) {
        validateExistsUserByEmail(request.getEmail());
        var userToCreate = userRequestMapper.toDomain(request);
            userToCreate.setToken("XXXXXXXXX");
        var userCreated = userPersistencePort.create(userToCreate);

        return userResponseMapper.toResponse(userCreated);
    }

    private void validateExistsUserByEmail(String email) {
        userPersistencePort.getByEmail(email).ifPresent(user -> {
            throw new UnprocessableEntity("Email address already exists");
        });
    }

}
