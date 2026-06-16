package com.eventflow.userservice.controller;

import com.eventflow.userservice.domain.entity.User;
import com.eventflow.userservice.dto.UserResponse;
import com.eventflow.userservice.service.AuthService;
import com.eventflow.userservice.service.LoginRequest;
import com.eventflow.userservice.service.LoginResponse;
import com.eventflow.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

        private final AuthService authService;

        public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/login")
        public ResponseEntity<User> loginUser(@RequestBody LoginRequest loginRequest){
            authService.loginUser(loginRequest);
            return ResponseEntity.ok().build();
        }

}
