package com.sda.weather.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LocalizationController {

    private final LocalizationService localizationService = new LocalizationService();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String addLocalization(String citiName, String region, String countryName, int latitude, int longitude) {
        LocalizationEntry localizationEntry = localizationService.addNewLocalization(citiName, region, countryName, latitude, longitude);

        try {
            return objectMapper.writeValueAsString(localizationEntry);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Obiekt localizationEntry nie może zostać zserializowany");
        }
    }
}
