package com.sda.weather.application;

import com.sda.weather.application.weather.WeatherForecastClient;
import com.sda.weather.application.weather.WeatherResponse;
import org.junit.jupiter.api.Test;

class WeatherForecastClientTest {

    private final WeatherForecastClient weatherForecastClient = new WeatherForecastClient();

    @Test
    void test() {
        WeatherResponse.ListItem result = weatherForecastClient.getWeather("London");
        System.out.println(result);
    }
}
