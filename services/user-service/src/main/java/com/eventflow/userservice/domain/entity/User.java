package com.eventflow.userservice.domain.entity;

import com.eventflow.userservice.domain.enums.UserStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter @Setter
@Table(name = "users")
public class User {

    @Id
    private UUID id;

    private String nome;

    private String sobrenome;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private LocalDateTime dataCriacao;

}
