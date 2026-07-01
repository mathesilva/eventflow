package com.eventflow.eventservice.dto;

import com.eventflow.eventservice.domain.enums.EventStatus;

import java.util.UUID;

public record EventSummaryResponse(UUID id, String titulo, EventStatus status, String location) {
}
