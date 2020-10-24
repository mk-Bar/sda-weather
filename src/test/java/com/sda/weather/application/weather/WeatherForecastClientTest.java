package com.sda.weather.application.weather;

import com.sda.weather.application.weather.WeatherForecastClient;
import com.sda.weather.application.weather.WeatherResponse;
import org.junit.jupiter.api.Test;

class WeatherForecastClientTest {

    private final WeatherForecastClient weatherForecastClient = new WeatherForecastClient();

    @Test
    void test() {
        WeatherResponse.ListItem result = weatherForecastClient.getWeather("London", "2020-10-26 12:00:00");
        System.out.println(result);
    }
}
