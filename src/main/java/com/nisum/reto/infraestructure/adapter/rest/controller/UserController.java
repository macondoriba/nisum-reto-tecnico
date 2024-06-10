package com.nisum.reto.infraestructure.adapter.rest.controller;

import com.nisum.reto.application.service.UserService;
import com.nisum.reto.domain.model.dto.request.UserRequest;
import com.nisum.reto.domain.model.dto.response.UserResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public UserResponse create(@RequestHeader("Authorization") String authorization, @RequestBody UserRequest userRequest){
        return userService.createNew(authorization,userRequest);
    }
}
