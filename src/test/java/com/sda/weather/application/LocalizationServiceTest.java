package com.sda.weather.application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceTest {

    LocalizationService localizationService = new LocalizationService();

    @Test
    void addNewLocalization_returnAdded() {
        // when
        LocalizationEntry addedLocalization = localizationService.addNewLocalization("city", "region", "country", 0, 0);

        // then
        assertNotNull(addedLocalization);
        assertEquals(addedLocalization.getCitiName(), "city");
        assertEquals(addedLocalization.getRegion(), "region");
        assertEquals(addedLocalization.getCountryName(), "country");
        assertEquals(addedLocalization.getLatitude(), 0);
        assertEquals(addedLocalization.getLongitude(), 0);
    }

    @Test
    void addEmptyCityLocalization() {
        // when
        assertThrows(Exception.class, () -> localizationService.addNewLocalization(" ", "region", "country", 0, 0));
    }

    @Test
    void addNewLocalizationWhenLongitudeIsAbove180_shouldThrowException() {
        // when
        assertThrows(Exception.class, () -> localizationService.addNewLocalization("city", "region", "country", 0, 181));
    }

    @Test
    void addNewLocalizationWhenLongitudeIsBelow180_shouldThrowException() {
        // when
        assertThrows(Exception.class, () -> localizationService.addNewLocalization("city", "region", "country", 0, -181));
    }
}
