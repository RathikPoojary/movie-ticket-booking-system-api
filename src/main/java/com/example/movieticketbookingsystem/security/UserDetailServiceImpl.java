package com.example.movieticketbookingsystem.security;

import com.example.movieticketbookingsystem.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.example.movieticketbookingsystem.entity.UserDetails user = userRepository.findByEmail(username);

        if(user == null) {
            log.error("Failed to find User by name: {}", username);
            throw new UsernameNotFoundException("Email not found in the database");
        }

        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(user.getUserRole().name())
                .build();
    }

}