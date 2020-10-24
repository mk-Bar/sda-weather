package com.sda.weather.customExceptions;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String errorMessage) {
        super(errorMessage);
    }
}
