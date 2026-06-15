package com.eventflow.userservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/health")
@RestController
public class HealthController {


    @GetMapping()
    public HttpStatusCode healthCheck(){
        return ResponseEntity.ok(HttpStatus.OK).getStatusCode();
    }

}
