package com.eventflow.eventservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record CreatEventRequest(@NotBlank
                                String title,
                                @NotBlank
                                String descricao,
                                @NotBlank
                                String location,
                                @NotNull
                                LocalDateTime eventDate,
                                @Positive
                                Integer totalTickets) {
}
