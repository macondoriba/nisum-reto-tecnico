package com.nisum.reto.domain.port;

import com.nisum.reto.domain.model.User;
import java.util.List;

public interface UserPersistencePort {
    User create(User user);
    List<User> getAll();
};
