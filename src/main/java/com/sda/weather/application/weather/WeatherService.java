package com.sda.weather.application.weather;

import java.util.List;

public class WeatherService {
    private final WeatherRepository weatherRepository = new WeatherRepository();

    public WeatherEntry addNewWeather(final String cityName) {

        // todo use WeatherForecastClient, pass cityName, retrieve WeatherResponse
        // todo map (translate) WeatherResponse to WeatherEntry
        // todo save new WeatherEntry to database by using WeatherRepository
        // todo return WeatherEntry

        return null;
    }

    public List<WeatherEntry> readSavedWeather() {
        return weatherRepository.readSavedWeather();
    }
}
