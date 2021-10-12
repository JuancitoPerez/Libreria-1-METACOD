package com.example.template.exceptions;

import org.springframework.http.HttpStatus;

public class PrestamoAlreadyExistException extends ResponseException{
    public PrestamoAlreadyExistException() {
        super("El/La Prestamo ya existe ", HttpStatus.BAD_REQUEST);
    }
}
