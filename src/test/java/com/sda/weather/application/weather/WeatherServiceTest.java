package com.sda.weather.application.weather;

import com.sda.weather.application.localization.LocalizationEntry;
import com.sda.weather.application.localization.LocalizationRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherServiceTest {

    LocalizationRepository localizationRepository = new LocalizationRepository();
    WeatherService weatherService = new WeatherService();

    @Test
    void getNewWeatherTest() { // todo change name
        // given
        localizationRepository.saveNewEntry(new LocalizationEntry("Warszawa", "region", "Polska", 30, 30));

        // when
        WeatherEntry newWeather = weatherService.getNewWeather("Warszawa", "2020-10-26 12:00:00");

        // then
        assertEquals(newWeather.getCityName(), "Warszawa");
        assertTrue(Double.parseDouble(newWeather.getWindSpeed()) >= 0);
        assertEquals(newWeather.getLocalDate().toString(), "2020-10-26T12:00");
    }
}
