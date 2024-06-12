package com.nisum.reto.application.usecase;

import com.nisum.reto.application.util.mapper.UserResponseMapper;
import com.nisum.reto.application.util.mapper.UserRequestMapper;
import com.nisum.reto.application.port.in.UserWebPort;
import com.nisum.reto.application.util.constants.UserConstant;
import com.nisum.reto.domain.model.dto.request.UserRequest;
import com.nisum.reto.domain.model.dto.response.UserResponse;
import com.nisum.reto.application.port.in.RegularExpresionFrameworkPort;
import com.nisum.reto.application.port.out.RegularExpresionPersistencePort;
import com.nisum.reto.application.port.out.UserPersistencePort;
import com.nisum.reto.infraestructure.adapter.util.exception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Service
public class UserUseCase implements UserWebPort {

    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper;
    private final UserPersistencePort userPersistencePort;
    private final RegularExpresionFrameworkPort regularExpresionFrameworkPort;
    private final RegularExpresionPersistencePort regularExpresionPersistencePort;

    @Autowired
    public UserUseCase(UserRequestMapper userRequestMapper,
                       UserResponseMapper userResponseMapper,
                       UserPersistencePort userPersistencePort,
                       RegularExpresionFrameworkPort regularExpresionFrameworkPort,
                       RegularExpresionPersistencePort regularExpresionPersistencePort) {
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
            if(!regularExpresionFrameworkPort.validateRegularExpresionPassword(request.getPassword(),passwords.get(0).getExpression()))   {
                throw new UserException(HttpStatus.BAD_REQUEST,
                        String.format(UserConstant.PASSWORD_REGULAR_EXPRESSION_INVALID_FORMAT));
            }
        }else{
            throw new UserException(HttpStatus.BAD_REQUEST,
                    String.format(UserConstant.PASSWORD_REGULAR_EXPRESSION_NOT_FOUND));
        }

    }





}
