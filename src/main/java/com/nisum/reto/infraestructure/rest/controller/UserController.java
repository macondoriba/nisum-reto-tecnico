package com.nisum.reto.infraestructure.rest.controller;

import com.nisum.reto.application.service.UserService;

import com.nisum.reto.domain.model.dto.request.UserRequest;
import com.nisum.reto.domain.model.dto.response.UserResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserResponse create(@RequestBody UserRequest userRequest){
        return userService.createNew(userRequest);
    }
}
