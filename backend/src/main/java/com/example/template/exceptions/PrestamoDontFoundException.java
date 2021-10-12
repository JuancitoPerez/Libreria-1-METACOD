package com.example.template.exceptions;

import org.springframework.http.HttpStatus;

public class PrestamoDontFoundException extends ResponseException{
    public PrestamoDontFoundException(long id) {
        super("El/La Prestamo con id "+ id +" no existe", HttpStatus.NOT_FOUND);
    }
}
