package com.eventflow.userservice.dto;

import java.util.UUID;

public record UserResponse(UUID id,
                           String nome,
                           String email) {
}
