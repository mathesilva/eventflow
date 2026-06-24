package com.eventflow.eventservice.domain.entity;

import com.eventflow.eventservice.domain.enums.EventStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter @Setter
@Table(name = "events")
public class Event {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;

    private String titulo;
    private String descricao;
    private String location;
    private LocalDateTime eventDate;
    private Integer totalTickets;
    private Integer ticketsDisponiveis;

    private EventStatus status;

    private UUID organizerID;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
