package com.nisum.reto.infraestructure.adapter.framework.security;

import com.nisum.reto.domain.model.User;
import com.nisum.reto.infraestructure.adapter.persistence.entity.UserEntity;
import com.nisum.reto.infraestructure.adapter.persistence.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = this.userRepository
                .findOneByEmailAndIsActive(email, true)
                .orElseThrow(() -> new UsernameNotFoundException("Incorrect username or password"));

        user.setLastLogin(LocalDateTime.now());
      /* Optional<User> user = this.userRepository.findAll()
                .stream()
                .filter(p->p.getEmail().equals(email))
                .filter(p->p.getIsActive().equals(true))
                .collect(Collectors.toList()).get(0)
                .orElseThrow(() -> new UsernameNotFoundException("Incorrect username or password"));

        user.setLastLogin(LocalDateTime.now());*/
        //this.userRepository.save(user);

        return new UserDetailsImpl(user);
    }
}
