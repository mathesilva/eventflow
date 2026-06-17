package com.eventflow.userservice.controller;


import com.eventflow.userservice.dto.LoginResponse;
import com.eventflow.userservice.security.JwtService;
import com.eventflow.userservice.dto.LoginRequest;
import com.eventflow.userservice.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
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
        public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest login){
            return ResponseEntity.ok(authService.loginUser(login));
        }

}
