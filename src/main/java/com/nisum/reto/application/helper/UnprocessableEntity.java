package com.nisum.reto.application.helper;

public class UnprocessableEntity extends RuntimeException {

    public UnprocessableEntity(String message) {
        super(message);
    }

}
