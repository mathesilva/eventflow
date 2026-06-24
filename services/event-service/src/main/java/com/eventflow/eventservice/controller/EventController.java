package com.eventflow.eventservice.controller;

import com.eventflow.eventservice.dto.CreatEventRequest;
import com.eventflow.eventservice.dto.EventResponse;
import com.eventflow.eventservice.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EventController {

        private final EventService eventService;

        public EventController(EventService eventService) {
        this.eventService = eventService;}


        @PostMapping("/eventos")
        public ResponseEntity<EventResponse> creatEvent(@RequestBody CreatEventRequest request){
            EventResponse eventCriado = eventService.createEvent(request);
            return ResponseEntity.ok(eventCriado);
        }
}
