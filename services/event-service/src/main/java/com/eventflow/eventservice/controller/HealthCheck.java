package com.eventflow.eventservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/health")
public class HealthCheck {

    @GetMapping
    public Map<String, String>healthCheck(){
        return Map.of("status", "UP");
    }


}
