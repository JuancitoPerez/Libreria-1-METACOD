package com.example.template.exceptions;

import org.springframework.http.HttpStatus;

public class MultaAlreadyExistException extends ResponseException{
    public MultaAlreadyExistException() {
        super("El/La Multa ya existe ", HttpStatus.BAD_REQUEST);
    }
}
