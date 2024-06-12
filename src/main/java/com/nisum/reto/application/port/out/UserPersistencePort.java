package com.nisum.reto.application.port.out;

import com.nisum.reto.domain.model.User;
import java.util.List;

public interface UserPersistencePort {
    User create(User user);
    List<User> getAll();
};
