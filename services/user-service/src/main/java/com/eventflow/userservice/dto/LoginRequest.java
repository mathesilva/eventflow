package com.eventflow.userservice.dto;

import jakarta.validation.constraints.NotEmpty;

public record LoginRequest(@NotEmpty(message = "senha é obrigatória")
                           String email,
                           @NotEmpty(message = "senha é obrigatória")
                           String password
                           ) {
}
