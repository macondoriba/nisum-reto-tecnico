package com.nisum.reto.domain.port;

import com.nisum.reto.domain.model.User;

public interface UserPersistencePort {
    User create(User user);
    User getByEmail(String email);
};
