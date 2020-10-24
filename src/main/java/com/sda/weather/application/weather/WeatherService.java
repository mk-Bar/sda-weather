package com.sda.weather.application.weather;

import com.sda.weather.application.localization.LocalizationEntry;
import com.sda.weather.application.localization.LocalizationRepository;

import java.util.List;

public class WeatherService {
    private final WeatherRepository weatherRepository = new WeatherRepository();

    public WeatherEntry addNewWeather(final String citiname, final String dt_txt, final String windSpeed) {

        WeatherEntry weatherEntry = new WeatherEntry(citiname, dt_txt, windSpeed);
        WeatherEntry savedWaether = weatherRepository.saveNewEntry(weatherEntry);

        return savedWaether;
    }

    public List<WeatherEntry> readSavedWeather() {
        return weatherRepository.readSavedWeather();
    }
}
