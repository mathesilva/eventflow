package com.eventflow.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/health")
@RestController
public class HealthController {


    @GetMapping()
    public Map<String, String> healthCheck(){
        return Map.of("status", "UP");
    }

//    @Value("${jwt.secret}")
//    private String jwtSecret;
//
//    @Value("${spring.datasource.url}")
//    private String dbUrl;
//
//    @GetMapping
//    public Map<String, String> test() {
//        return Map.of(
//                "jwt", jwtSecret,
//                "db", dbUrl
//        );
//    }
}
