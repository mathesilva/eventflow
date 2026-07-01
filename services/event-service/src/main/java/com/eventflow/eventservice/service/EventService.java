package com.eventflow.eventservice.service;

import com.eventflow.eventservice.domain.entity.Event;
import com.eventflow.eventservice.domain.enums.EventStatus;
import com.eventflow.eventservice.dto.CreatEventRequest;
import com.eventflow.eventservice.dto.EventDetailResponse;
import com.eventflow.eventservice.dto.EventResponse;
import com.eventflow.eventservice.dto.EventSummaryResponse;
import com.eventflow.eventservice.exception.InvalidEventStatusException;
import com.eventflow.eventservice.exception.NaoEncontradoException;
import com.eventflow.eventservice.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    public EventResponse createEvent(CreatEventRequest request){
        Event event = new Event();

        event.setTitulo(request.title());
        event.setDescricao(request.descricao());
        event.setLocation(request.location());
        event.setEventDate(request.eventDate());
        event.setTotalTickets(request.totalTickets());
        event.setTicketsDisponiveis(request.totalTickets());
        event.setStatus(EventStatus.RASCUNHO);
        event.setOrganizerID(UUID.randomUUID());
        Event newEvent = eventRepository.save(event);

        return new EventResponse(newEvent.getId(), newEvent.getTitulo(), newEvent.getStatus());
    }

    public List<EventSummaryResponse> findAll() {
        return eventRepository.findAll()
                .stream()
                .map(this::toSummaryResponse)
                .toList();
    }

    public Optional<EventDetailResponse> findById(UUID id) {
        return eventRepository.findById(id)
                .map(this::toDetailResponse);
    }

    private EventSummaryResponse toSummaryResponse(Event event) {
        return new EventSummaryResponse(
                event.getId(),
                event.getTitulo(),
                event.getStatus(),
                event.getLocation()
        );
    }

    private EventDetailResponse toDetailResponse(Event event) {
        return new EventDetailResponse(
                event.getId(),
                event.getTitulo(),
                event.getDescricao(),
                event.getLocation(),
                event.getEventDate(),
                event.getStatus(),
                event.getTotalTickets(),
                event.getTicketsDisponiveis()
        );
    }

    public EventResponse publicado(UUID id){
        Event event = eventRepository.findById(id).orElseThrow(()-> new NaoEncontradoException("Usuario nao encontado"));
        if (event.getStatus() != EventStatus.RASCUNHO){
            throw new InvalidEventStatusException("O evento já foi publicado.");
        }
        event.setStatus(EventStatus.PUBLICADO);
        eventRepository.save(event);

        return new EventResponse(event.getId(), event.getTitulo(), event.getStatus());
    }

}
