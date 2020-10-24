package com.sda.weather.application.weather;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherServiceTest {
    WeatherService weatherService = new WeatherService();

    @Test
    void getNewWeatherTest() {
        //given
        WeatherEntry newWeather = weatherService.getNewWeather("warszawa");


    }

}