package com.eventflow.userservice.service;

import com.eventflow.userservice.domain.entity.User;
import com.eventflow.userservice.domain.enums.UserRole;
import com.eventflow.userservice.domain.enums.UserStatus;
import com.eventflow.userservice.dto.CreateUserRequest;
import com.eventflow.userservice.dto.UserResponse;
import com.eventflow.userservice.exception.EmailJaCadastradoException;
import com.eventflow.userservice.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse criarUsuario(CreateUserRequest request){
        if (userRepository.existsByEmail(request.email())){
            throw new EmailJaCadastradoException("Email ja cadastrado na plataforma!");
        }
        User user = new User();
        user.setNome(request.nome());
        user.setSobrenome(request.sobrenome());
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setStatus(UserStatus.ATIVO);
        user.setDataCriacao(LocalDateTime.now());
        user.setUserRole(UserRole.CUSTOMER);

        User newUser = userRepository.save(user);

        return new UserResponse(
                newUser.getId(),
                newUser.getNome(),
                newUser.getEmail());
    }



}
