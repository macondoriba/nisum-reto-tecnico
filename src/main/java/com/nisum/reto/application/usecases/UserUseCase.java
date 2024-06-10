package com.nisum.reto.application.usecases;

import com.nisum.reto.domain.model.dto.request.UserRequest;
import com.nisum.reto.domain.model.dto.response.UserResponse;

public interface UserUseCase {
    UserResponse createNew(String token, UserRequest request);
}
