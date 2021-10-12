package com.example.template.exceptions;

import org.springframework.http.HttpStatus;

public class LectorDontFoundException extends ResponseException{
    public LectorDontFoundException(long id) {
        super("El/La Lector con id "+ id +" no existe", HttpStatus.NOT_FOUND);
    }
}
