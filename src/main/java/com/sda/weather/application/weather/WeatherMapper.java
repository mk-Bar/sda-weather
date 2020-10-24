package com.sda.weather.application.weather;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WeatherMapper {

    public WeatherEntry mapToWeather(WeatherResponse.ListItem weather, String cityName) {
        String date = weather.dt_txt;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(date, dateTimeFormatter);

        String windSpeed = weather.getWind().getSpeed();

        return new WeatherEntry(cityName, localDateTime, windSpeed);
    }
}
