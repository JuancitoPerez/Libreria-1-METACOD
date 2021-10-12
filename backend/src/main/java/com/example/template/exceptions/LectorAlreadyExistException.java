package com.example.template.exceptions;

import org.springframework.http.HttpStatus;

public class LectorAlreadyExistException extends ResponseException{
    public LectorAlreadyExistException() {
        super("El/La Lector ya existe ", HttpStatus.BAD_REQUEST);
    }
}
