package com.nisum.reto.domain.port;

import com.nisum.reto.domain.model.User;

import java.util.Optional;

public interface UserPersistencePort {
    User create(User user);
    Optional<User> getByEmail(String email);
};
