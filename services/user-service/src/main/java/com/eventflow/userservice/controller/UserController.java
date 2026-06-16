package com.eventflow.userservice.controller;

import com.eventflow.userservice.domain.entity.User;
import com.eventflow.userservice.dto.CreateUserRequest;
import com.eventflow.userservice.dto.UserResponse;
import com.eventflow.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<UserResponse> criarUser(@RequestBody CreateUserRequest request){
        UserResponse response = userService.criarUsuario(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}
