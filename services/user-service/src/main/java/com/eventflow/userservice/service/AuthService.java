package com.eventflow.userservice.service;

import com.eventflow.userservice.domain.entity.User;
import com.eventflow.userservice.domain.enums.UserStatus;
import com.eventflow.userservice.dto.LoginRequest;
import com.eventflow.userservice.dto.LoginResponse;
import com.eventflow.userservice.exception.InvalidCredentialsException;
import com.eventflow.userservice.repository.UserRepository;
import com.eventflow.userservice.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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


    public void loginUser(LoginRequest login){

        User user = userRepository.findByEmail(login.email())
                .orElseThrow(()->
                new InvalidCredentialsException("Credenciais Invalidas"));

        if (user.getStatus() == UserStatus.INATIVO || user.getStatus() == UserStatus.BLOQUEADO){
            throw new InvalidCredentialsException("Credenciais Invalidas");
        }

        boolean senhaValida = passwordEncoder.matches(login.password(), user.getPassword());

        if (!senhaValida){
            throw new InvalidCredentialsException("Credenciais Invalidas");
        }
    }

}
