package com.sda.weather.customExceptions;

public class BadWeatherDataException extends RuntimeException {

    public BadWeatherDataException(String errorMessage) {
        super(errorMessage);
    }
}