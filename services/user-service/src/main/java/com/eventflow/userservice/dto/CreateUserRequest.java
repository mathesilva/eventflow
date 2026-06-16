package com.eventflow.userservice.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateUserRequest(@NotBlank String nome, @NotBlank String sobrenome, @NotBlank String email, @NotBlank String senha) {
}
