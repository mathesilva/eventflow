package com.eventflow.eventservice.service;

import com.eventflow.eventservice.domain.entity.Event;
import com.eventflow.eventservice.domain.enums.EventStatus;
import com.eventflow.eventservice.dto.CreatEventRequest;
import com.eventflow.eventservice.dto.EventResponse;
import com.eventflow.eventservice.repository.EventRepository;
import org.springframework.stereotype.Service;

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


}
