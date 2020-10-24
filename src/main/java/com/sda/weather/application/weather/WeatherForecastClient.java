package com.sda.weather.application.weather;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.weather.customExceptions.BadGatewayException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class WeatherForecastClient {

    private final String API_KEY = "8f42cebf4b535b0e39e927dabd571a31";
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public WeatherForecastClient() {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);  // co to jest?  jesli nie odwzowrujemy 1:1 to bezeie wyjątek. argument false pozwala to ominmąc
        objectMapper.findAndRegisterModules();
    }

    public WeatherResponse.ListItem getWeather(String cityName) {
        String uri = String.format("http://api.openweathermap.org/data/2.5/forecast?q=%s&appid=%s", cityName, API_KEY);
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(uri))
                .build();

        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            String responseBody = httpResponse.body();

            WeatherResponse weatherResponse = objectMapper.readValue(responseBody, WeatherResponse.class);

            WeatherResponse.ListItem listItem = weatherResponse.getList().stream()
//                    .filter( listItem -> )    // todo filter to obtain a forecast for next day
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("...")); // todo create your own exception;

            return listItem;
        } catch (Exception e) {
            System.out.println("Nieudana próba polączenia: " + e.getMessage());
            throw new BadGatewayException("BadGatewayException -> 502");
        }
    }
}
