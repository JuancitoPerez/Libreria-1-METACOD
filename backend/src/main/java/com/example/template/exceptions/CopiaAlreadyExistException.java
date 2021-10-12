package com.example.template.exceptions;

import org.springframework.http.HttpStatus;

public class CopiaAlreadyExistException extends ResponseException{
    public CopiaAlreadyExistException() {
        super("El/La Copia ya existe ", HttpStatus.BAD_REQUEST);
    }
}
