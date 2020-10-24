package com.sda.weather.application.weather;

import com.sda.weather.application.localization.LocalizationEntry;
import com.sda.weather.application.localization.LocalizationRepository;
import com.sda.weather.client.ExampleClient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

public class WeatherService {
    private final WeatherRepository weatherRepository = new WeatherRepository();

    public WeatherEntry getNewWeather(final String cityName, String data) {


        LocalizationRepository localizationRepository = new LocalizationRepository();
        boolean ifCityExistsInDatabase = localizationRepository.readAllSavedPlaces().stream()
                .anyMatch(localizationEntry -> localizationEntry.getCitiName().equals(cityName));
        if (ifCityExistsInDatabase) {

            WeatherForecastClient weatherForecastClient = new WeatherForecastClient();
            WeatherResponse.ListItem weather = weatherForecastClient.getWeather(cityName, data);
//    LocalDateTime date = LocalDateTime.parse(weather.dt_txt);
            String date = weather.dt_txt;
            String windSpeed = weather.getWind().getSpeed();

            WeatherEntry weatherEntry = new WeatherEntry(cityName, date, windSpeed);
            WeatherEntry saveNewEntry = weatherRepository.saveNewEntry(weatherEntry);
            return saveNewEntry;
        } else {
            System.out.println("nie ma takiego miasta w bazie danych. najpierw dodaj miasto");
//    ExampleClient client = new ExampleClient();
//    client.addLocalization();

        }
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
