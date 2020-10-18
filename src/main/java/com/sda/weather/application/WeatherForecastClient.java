package com.sda.weather.application;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherForecastClient {

    private final String API_KEY = "8f42cebf4b535b0e39e927dabd571a31";
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public WeatherForecastClient() {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);  // co to jest?
        objectMapper.findAndRegisterModules();
    }

    public String getWeather(String cityName) {
        String uri = String.format("http://api.openweathermap.org/data/2.5/forecast?q=%s&appid=%s", cityName, API_KEY);
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(uri))
                .build();

        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            String weatherResponse = httpResponse.body();

            // todo: map to WeatherResponse -> objectMapper.readValue()

            return weatherResponse;
        } catch (Exception e) {
            System.out.println("Nieudana próba polączenia: " + e.getMessage());
            throw new RuntimeException("..."); // todo: create new exception eg. BadGatewayException -> 502
        }
    }
}
