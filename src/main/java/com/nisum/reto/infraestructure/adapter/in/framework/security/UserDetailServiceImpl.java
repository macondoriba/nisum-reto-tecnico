package com.nisum.reto.infraestructure.adapter.in.framework.security;

import com.nisum.reto.infraestructure.adapter.out.persistence.entity.UserEntity;
import com.nisum.reto.infraestructure.adapter.out.persistence.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

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

        return new UserDetailsImpl(user);
    }
}
