package com.nisum.reto.infraestructure;

import com.nisum.reto.domain.model.User;
import com.nisum.reto.domain.port.UserPersistencePort;
import com.nisum.reto.infraestructure.adapter.mapper.UserDboMapper;
import com.nisum.reto.infraestructure.adapter.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    public User getByEmail(String email) {
        return userRepository.findAll()
                .stream()
                .map(userDboMapper::toDomain)
                .filter(p->p.getEmail().equals(email))
                .collect(Collectors.toList())
                .get(0);
    }
}
