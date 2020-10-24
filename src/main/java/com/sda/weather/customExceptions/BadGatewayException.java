package com.sda.weather.customExceptions;

public class BadGatewayException extends RuntimeException {

    public BadGatewayException(String errorMessage) {
        super(errorMessage);
    }
}
