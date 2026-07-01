package com.eventflow.eventservice.controller;

import com.eventflow.eventservice.dto.CreatEventRequest;
import com.eventflow.eventservice.dto.EventDetailResponse;
import com.eventflow.eventservice.dto.EventResponse;
import com.eventflow.eventservice.dto.EventSummaryResponse;
import com.eventflow.eventservice.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class EventController {

        private final EventService eventService;

        public EventController(EventService eventService) {
        this.eventService = eventService;}

        @PostMapping("/eventos")
        public ResponseEntity<EventResponse> creatEvent(@RequestBody CreatEventRequest request){
            EventResponse eventCriado = eventService.createEvent(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(eventCriado);
        }

        @GetMapping("/events")
        public ResponseEntity<List<EventSummaryResponse>> findAll(){
            List<EventSummaryResponse> events = eventService.findAll();
            return ResponseEntity.ok(events);
        }

        @GetMapping("/events/{id}")
        public ResponseEntity<EventDetailResponse> findById(@PathVariable UUID id){
            return eventService.findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @PatchMapping("/events/{id}/publish")
        public EventResponse publicar(@PathVariable UUID id){
            return eventService.publicado(id);
        }

}
