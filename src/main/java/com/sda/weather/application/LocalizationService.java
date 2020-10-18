package com.sda.weather.application;

import java.time.Instant;

public class LocalizationService {
    private final LocalizationRepository localizationRepository = new LocalizationRepository();

    public LocalizationEntry addNewLocalization(final String citiName, final String region, final String countryName, final int latitude, final int longitude) {
        if (citiName == null || citiName.isEmpty()) {
//            throw new RuntimeException("pole z nazwą miasta nie może być puste");
            System.out.println("pole z nazwą miasta nie może być puste. dodaj ponownie dane");
            return null;
        }
        if (countryName == null || countryName.isEmpty()) {
            throw new RuntimeException("pole z nazwą państwa nie może być puste");
        }

        if (latitude < -90 || latitude > 90) {   //jak sprawdzic czy jest typu int, czy jest liczba?
            throw new RuntimeException("wartosci szerokosci geograficznej musi byc w zakrsie od-90° do +90°");
        }

        if (longitude < -180 || longitude > 180) {   //jak sprawdzic czy jest typu int, czy jest liczba?
            throw new RuntimeException("wartosci długości geograficznej musi byc w zakrsie od-180° do +180°");
        }

//        Instant time = timeService.getTime();

        LocalizationEntry localizationEntry = new LocalizationEntry(citiName, region, countryName, latitude, longitude);
        LocalizationEntry savedLocalization = localizationRepository.saveNewEntry(localizationEntry);
        return savedLocalization;
    }
}
