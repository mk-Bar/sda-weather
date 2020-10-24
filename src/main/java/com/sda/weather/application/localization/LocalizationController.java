package com.sda.weather.application.localization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.weather.customExceptions.InternalServerException;

import java.util.List;

public class LocalizationController {

    private final LocalizationService localizationService = new LocalizationService();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String addLocalization(String citiName, String region, String countryName, int latitude, int longitude) {
        LocalizationEntry localizationEntry = localizationService.addNewLocalization(citiName, region, countryName, latitude, longitude);

        try {
            return objectMapper.writeValueAsString(localizationEntry);
        } catch (JsonProcessingException e) {
            throw new InternalServerException("InternalServerException -> 500: Obiekt localizationEntry nie może zostać zserializowany");
        }
    }


    public String showAddedPlaces() {
        List<LocalizationEntry> savedPlaces = localizationService.readAllSavedPlaces();
        try {
            return objectMapper.writeValueAsString(savedPlaces);
        } catch (JsonProcessingException e) {
            throw new InternalServerException("InternalServerException -> 500: Obiekt localizationEntry nie może zostać zserializowany");
        }
    }
}
