package com.nisum.reto.infraestructure.adapter.persistence;

import com.nisum.reto.domain.model.User;
import com.nisum.reto.domain.port.UserPersistencePort;
import com.nisum.reto.infraestructure.adapter.persistence.mapper.UserDboMapper;
import com.nisum.reto.infraestructure.adapter.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserSpringJpaAdapter implements UserPersistencePort {
    private final UserRepository userRepository;
    private final UserDboMapper userDboMapper;

    public UserSpringJpaAdapter(UserRepository userRepository, UserDboMapper userDboMapper) {
        this.userRepository = userRepository;
        this.userDboMapper = userDboMapper;
    }

    @Override
    public User create(User user) {
        var userToSave = userDboMapper.toDbo(user);
        var userSaved = userRepository.save(userToSave);
        return userDboMapper.toDomain(userSaved);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userDboMapper::toDomain)
                .collect(Collectors.toList());
    }

}
