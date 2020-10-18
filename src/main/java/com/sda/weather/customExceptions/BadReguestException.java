package com.sda.weather.customExceptions;

public class BadReguestException extends RuntimeException {

    public BadReguestException(String errorMessage) {
        super(errorMessage);
    }
}
