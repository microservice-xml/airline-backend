package com.example.airlinebackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)

public class TicketException extends RuntimeException {

    public TicketException(String message) {
        super(message);
    }
}