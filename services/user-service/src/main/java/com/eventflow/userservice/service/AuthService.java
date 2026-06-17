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
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }


    public LoginResponse loginUser(LoginRequest login){
        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken
                (login.email(), login.password());

        Authentication authentication = authenticationManager.authenticate(userAndPass);

        User userAuth = (User) authentication.getPrincipal();
        String token = jwtService.gerarToken(userAuth);
        return new LoginResponse(token);
    }

}
