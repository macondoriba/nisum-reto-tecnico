package com.nisum.reto.application.port.in;

import com.nisum.reto.domain.model.dto.request.UserRequest;
import com.nisum.reto.domain.model.dto.response.UserResponse;

public interface UserWebPort {
    UserResponse createNew(String token, UserRequest request);
}
