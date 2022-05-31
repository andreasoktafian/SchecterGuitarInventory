package com.andreas.SchecterGuitarInventory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CustomException extends ResponseStatusException {
    public CustomException(HttpStatus status, String reason) {
        super(status, reason);
    }
}
