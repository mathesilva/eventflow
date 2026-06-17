package com.eventflow.userservice.security;

import com.eventflow.userservice.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class JwtAuthenticationEntryPoint implements UserDetailsService {

    private final UserRepository userRepository;


    public JwtAuthenticationEntryPoint(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        return userRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("Usuario nao encontrado" + username));
    }

}
