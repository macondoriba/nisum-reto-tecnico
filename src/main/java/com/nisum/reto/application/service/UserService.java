package com.nisum.reto.application.service;

import com.nisum.reto.application.mapper.UserResponseMapper;
import com.nisum.reto.application.mapper.UserRequestMapper;
import com.nisum.reto.application.usecases.UserUseCase;

import com.nisum.reto.domain.constant.UserConstant;
import com.nisum.reto.domain.model.dto.request.UserRequest;
import com.nisum.reto.domain.model.dto.response.UserResponse;
import com.nisum.reto.domain.port.UserPersistencePort;
import com.nisum.reto.infraestructure.adapter.exception.UserException;
import org.springframework.http.HttpStatus;
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
    public UserResponse createNew(String token, UserRequest request) {
        if(!userPersistencePort.getByEmail(request.getEmail()).isEmpty())
        {
            throw new UserException(HttpStatus.BAD_REQUEST,
                    String.format(UserConstant.EMAIL_ADDRESS_ALREADY_EXISTS, request.getEmail()));
        }
        var userToCreate = userRequestMapper.toDomain(request);
            userToCreate.setToken(token.replace("Bearer", ""));
            userToCreate.setActivityStatus();
        var userCreated = userPersistencePort.create(userToCreate);

        return userResponseMapper.toResponse(userCreated);
    }


}
