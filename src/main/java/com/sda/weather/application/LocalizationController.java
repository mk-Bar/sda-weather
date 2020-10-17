package com.sda.weather.application;

public class LocalizationController {
    private final LocalizationService localizationService = new LocalizationService();

    public String addLocalization(String citiName, String region, String countryName, int latitude, int longitude) {
        LocalizationEntry localizationEntry = localizationService.addNewLocalization(citiName, region, countryName, latitude, longitude);
        return localizationEntry.toString();
    }
}
