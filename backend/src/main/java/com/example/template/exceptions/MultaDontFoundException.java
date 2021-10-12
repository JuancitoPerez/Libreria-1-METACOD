package com.example.template.exceptions;

import org.springframework.http.HttpStatus;

public class MultaDontFoundException extends ResponseException{
    public MultaDontFoundException(long id) {
        super("El/La Multa con id "+ id +" no existe", HttpStatus.NOT_FOUND);
    }
}
