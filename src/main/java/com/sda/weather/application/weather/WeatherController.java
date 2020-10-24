package com.sda.weather.application.weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.weather.application.localization.LocalizationEntry;
import com.sda.weather.application.localization.LocalizationService;
import com.sda.weather.customExceptions.InternalServerException;

import java.util.List;

public class WeatherController {
    private final WeatherService weatherService = new WeatherService();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String CheckWeather(String citiname) {
        if ()
            WeatherEntry weatherEntry = weatherService.addNewWeather(citiname);

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


