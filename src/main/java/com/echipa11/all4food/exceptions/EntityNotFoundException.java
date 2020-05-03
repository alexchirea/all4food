package com.echipa11.all4food.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException() {
        super("Resursa dorita nu a fost gasita!");
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
