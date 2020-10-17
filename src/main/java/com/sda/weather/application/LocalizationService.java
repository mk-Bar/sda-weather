package com.sda.weather.application;

import java.time.Instant;

public class LocalizationService {
    private final LocalizationRepository localizationRepository = new LocalizationRepository();

    public LocalizationEntry addNewLocalization(final String citiName, final String region, final String countryName, final int latitude, final int longitude) {
        if (citiName == null || citiName.isEmpty()) {
            throw new RuntimeException("pole z nazwą miasta nie może być puste");
        }
        if (countryName == null || countryName.isEmpty()) {
            throw new RuntimeException("pole z nazwą państwa nie może być puste");
        }

//        Instant time = timeService.getTime();

        LocalizationEntry localizationEntry = new LocalizationEntry(citiName, region, countryName, latitude, longitude);
        LocalizationEntry savedLocalization = localizationRepository.saveNewEntry(localizationEntry);
        return savedLocalization;
    }
}
