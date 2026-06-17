package com.eventflow.userservice.controller;

import com.eventflow.userservice.domain.entity.User;
import com.eventflow.userservice.dto.LoginResponse;
import com.eventflow.userservice.security.JwtService;
import com.eventflow.userservice.service.AuthService;
import com.eventflow.userservice.dto.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

        private final AuthService authService;
        private final JwtService jwtService;
        private final AuthenticationManager authenticationManager;

        public AuthController(AuthService authService, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.authService = authService;
            this.jwtService = jwtService;
            this.authenticationManager = authenticationManager;
        }


    @PostMapping("/login")
        public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest login){
        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(login.email(), login.password());
        Authentication authentication = authenticationManager.authenticate(userAndPass);

        User userAuth = (User) authentication.getPrincipal();
        String token = jwtService.gerarToken(userAuth);
            authService.loginUser(login);
            return ResponseEntity.ok(new LoginResponse(token));
        }

}
