package com.sda.weather.customExceptions;

public class InternalServerException extends RuntimeException {

    public InternalServerException(String errorMessage) {
        super(errorMessage);
    }
}
