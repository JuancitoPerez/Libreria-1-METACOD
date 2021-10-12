package com.example.template.exceptions;

import org.springframework.http.HttpStatus;

public class CopiaDontFoundException extends ResponseException{
    public CopiaDontFoundException(long id) {
        super("El/La Copia con id "+ id +" no existe", HttpStatus.NOT_FOUND);
    }
}
