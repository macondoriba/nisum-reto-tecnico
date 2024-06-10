package com.nisum.reto.application.service;

import com.nisum.reto.application.mapper.UserResponseMapper;
import com.nisum.reto.application.mapper.UserRequestMapper;
import com.nisum.reto.application.usecases.UserUseCase;
import com.nisum.reto.domain.constant.UserConstant;
import com.nisum.reto.domain.model.dto.request.UserRequest;
import com.nisum.reto.domain.model.dto.response.UserResponse;
import com.nisum.reto.domain.port.RegularExpresionFrameworkPort;
import com.nisum.reto.domain.port.RegularExpresionPersistencePort;
import com.nisum.reto.domain.port.UserPersistencePort;
import com.nisum.reto.infraestructure.adapter.exception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Service
public class UserService implements UserUseCase {

    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper;
    private final UserPersistencePort userPersistencePort;
    private final RegularExpresionFrameworkPort regularExpresionFrameworkPort;
    private final RegularExpresionPersistencePort regularExpresionPersistencePort;

    @Autowired
    public UserService(UserRequestMapper userRequestMapper,
                       UserResponseMapper userResponseMapper,
                       UserPersistencePort userPersistencePort, RegularExpresionFrameworkPort regularExpresionFrameworkPort, RegularExpresionPersistencePort regularExpresionPersistencePort) {
        this.userRequestMapper = userRequestMapper;
        this.userResponseMapper = userResponseMapper;
        this.userPersistencePort = userPersistencePort;
        this.regularExpresionFrameworkPort = regularExpresionFrameworkPort;
        this.regularExpresionPersistencePort = regularExpresionPersistencePort;
    }

    @Override
    public UserResponse createNew(String token, UserRequest request) {

        validacionEmail(request);
        validacionPassword(request);
        var userToCreate = userRequestMapper.toDomain(request);
            userToCreate.setToken(token.replace(UserConstant.BEARER, ""));
            userToCreate.setActivityStatus();
        var userCreated = userPersistencePort.create(userToCreate);

        return userResponseMapper.toResponse(userCreated);
    }

    private void validacionEmail(UserRequest request){

        if(!regularExpresionFrameworkPort.validateRegularExpresionEmail(request.getEmail()))   {
            throw new UserException(HttpStatus.BAD_REQUEST,
                    String.format(UserConstant.EMAIL_ADDRESS_INVALID_FORMAT));
        }
        var users = userPersistencePort.getAll()
                .stream()
                .filter(p->p.getEmail().equals(request.getEmail()))
                .collect(Collectors.toList());

        if(!users.isEmpty())
        {
            throw new UserException(HttpStatus.BAD_REQUEST,
                    String.format(UserConstant.EMAIL_ADDRESS_ALREADY_EXISTS, request.getEmail()));
        }

    }

    private void validacionPassword(UserRequest request){
        var passwords = regularExpresionPersistencePort.getAll()
                .stream()
                .filter(p->p.getCode().equals(UserConstant.CODE_EXPRESSION_PASSWORD))
                .collect(Collectors.toList());
        if(!passwords.isEmpty()){
            if(!regularExpresionFrameworkPort.validateRegularExpresionPassword(passwords.get(0).getExpression(),request.getPassword()))   {
                throw new UserException(HttpStatus.BAD_REQUEST,
                        String.format(UserConstant.PASSWORD_REGULAR_EXPRESSION_INVALID_FORMAT));
            }
        }

    }





}
