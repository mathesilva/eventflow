package com.eventflow.eventservice.dto;

import com.eventflow.eventservice.domain.enums.EventStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventDetailResponse(UUID id,
                                  String titulo,
                                  String descricao,
                                  String location,
                                  LocalDateTime eventDate,
                                  EventStatus status,
                                  Integer totalTickets,
                                  Integer availableTickets) {
}
