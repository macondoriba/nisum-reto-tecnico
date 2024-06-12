package com.nisum.reto.infraestructure.adapter.in.web.rest.controller;

import com.nisum.reto.application.usecase.UserUseCase;
import com.nisum.reto.domain.model.dto.request.UserRequest;
import com.nisum.reto.domain.model.dto.response.UserResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserUseCase userUseCase;

    public UserController(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @PostMapping()
    public UserResponse create(@RequestHeader("Authorization") String authorization, @RequestBody UserRequest userRequest){
        return userUseCase.createNew(authorization,userRequest);
    }
}
