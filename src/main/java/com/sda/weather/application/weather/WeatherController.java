package com.sda.weather.application.weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.weather.customExceptions.InternalServerException;

public class WeatherController {
    private final WeatherService weatherService = new WeatherService();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String checkWeather(String cityName, String data) {
        WeatherEntry weatherEntry = weatherService.getNewWeather(cityName, data);

        try {
            return objectMapper.writeValueAsString(weatherEntry);
        } catch (JsonProcessingException e) {
            throw new InternalServerException("InternalServerException -> 500: Obiekt localizationEntry nie może zostać zserializowany");
        }
    }


//    public String showCheckedWeather() {
//        List<WeatherEntry> savedWeather = weatherService.readSavedWeather();
//        try {
//            return objectMapper.writeValueAsString(savedWeather);
//        } catch (JsonProcessingException e) {
//            throw new InternalServerException("InternalServerException -> 500: Obiekt localizationEntry nie może zostać zserializowany");
//        }
}


