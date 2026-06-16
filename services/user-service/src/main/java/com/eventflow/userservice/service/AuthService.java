package com.eventflow.userservice.service;

import com.eventflow.userservice.domain.entity.User;
import com.eventflow.userservice.domain.enums.UserStatus;
import com.eventflow.userservice.exception.InvalidCredentialsException;
import com.eventflow.userservice.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public User loginUser(LoginRequest login){
        User userLogado = new User();

        if (!userRepository.existsByEmail(login.email())){
            throw new InvalidCredentialsException("Credenciais Invalidas");
        }
        if (userLogado.getStatus() == UserStatus.INATIVO || userLogado.getStatus() == UserStatus.BLOQUEADO){
            throw new InvalidCredentialsException("Credenciais Invalidas");
        }
        if (!userRepository.existsByPassword(login.password())){
            throw new InvalidCredentialsException("Credenciais Invalidas");
        }
        passwordEncoder.matches(login.password(), userLogado.getPassword());
        return userLogado;
    }

}
