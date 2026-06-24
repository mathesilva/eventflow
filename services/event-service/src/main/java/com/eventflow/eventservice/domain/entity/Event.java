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

    @Column(name = "event_date")
    private LocalDateTime eventDate;
    private Integer totalTickets;

    @Column(name = "available_tickets")
    private Integer ticketsDisponiveis;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EventStatus status;

    @Column(name = "organizer_id")
    private UUID organizerID;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist(){
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    public void preUpdate(){
        this.updatedAt = LocalDateTime.now();
    }

}
