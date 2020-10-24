package com.sda.weather.application.weather;

import com.sda.weather.application.localization.LocalizationRepository;

import java.util.List;

public class WeatherService {

    private final WeatherRepository weatherRepository = new WeatherRepository();
    private final LocalizationRepository localizationRepository = new LocalizationRepository();
    private final WeatherForecastClient weatherForecastClient = new WeatherForecastClient();
    private final WeatherMapper weatherMapper = new WeatherMapper();

    public WeatherEntry getNewWeather(final String cityName, String data) {
        boolean isCityExists = localizationRepository.readAllSavedPlaces().stream()
                .anyMatch(localizationEntry -> localizationEntry.getCitiName().equals(cityName));

        if (isCityExists) {
            WeatherResponse.ListItem weather = weatherForecastClient.getWeather(cityName, data);
            WeatherEntry weatherEntry = weatherMapper.mapToWeather(weather, cityName);
            return weatherRepository.saveNewEntry(weatherEntry);
        } else {
            System.out.println("Nie ma takiego miasta w bazie danych. najpierw dodaj miasto");
            throw new RuntimeException("..."); // todo create your own exception -> HTTP 404 - Not Found
        }
    }

    public List<WeatherEntry> readSavedWeather() {
        return weatherRepository.readSavedWeather();
    }
}
