package com.eventflow.eventservice.exception;

public class InvalidEventStatusException extends RuntimeException {
    public InvalidEventStatusException(String message) {
        super(message);
    }
}
