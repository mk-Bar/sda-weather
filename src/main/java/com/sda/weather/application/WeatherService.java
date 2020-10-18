package com.sda.weather.application;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class WeatherService {
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public WeatherService() {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // co to jest?
        objectMapper.findAndRegisterModules();
    }


    String apiKey = "8f42cebf4b535b0e39e927dabd571a31";
    String cityName = "London";

    public String getWeather() {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + apiKey))
                .build();

        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            String weatherResponse = httpResponse.body();

//            String response = objectMapper.readValues();   //uzupelnic
            String getWeatherResponse = "odp na getWeather";


            return getWeatherResponse;
        } catch (Exception e) {
            System.out.println("Nieudana próba polączenia: " + e.getMessage());
            return Instant.now();
        }
    }
}
