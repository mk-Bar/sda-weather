package com.sda.weather.client;

import com.sda.weather.application.weather.WeatherController;
import com.sda.weather.customExceptions.BadRequestException;
import com.sda.weather.application.localization.LocalizationController;

import java.util.Scanner;

public class ExampleClient {
    private final LocalizationController localizationController = new LocalizationController();
    private final WeatherController weatherController = new WeatherController();

    public void runClientInterface() {
        System.out.println("Twoja aplikacja została uruchomiona");
        Scanner scanner = new Scanner(System.in);
        int response = 0;
        while (true) {
            System.out.println("Menu aplikacji Weather. Określ co chcesz zrobić: ");
            System.out.println("1. Dodaj lokalizację do bazy danych");
            System.out.println("2. Wyświetl aktualnie dodane lokalizacje");
            System.out.println("3. Pobierz wartości pogodowe");
            System.out.println("4. Zamknij aplikację");

            try {
                response = scanner.nextInt();
                switch (response) {
                    case 1:
                        addLocalization();
                        break;
                    case 2:
                        showAddedPlaces();
                        break;
                    case 3:
                        getWeatherParameters();
                        break;
                    case 4:
                        System.out.println("Twoja aplikacja jest zamykana");
                        return;
                }
            } catch (Exception e) {
                System.out.println("Wybierz wartość liczbową odpowiadającą danej funkcjonalności" + "\n");
                scanner.nextLine();

            }
        }
    }

    private void getWeatherParameters() {
        System.out.println("okresl lokalizację (miasto) dla jakiej chcesz sprawdzic prognoze pogody:");
        Scanner scanner = new Scanner(System.in);
        String cityName = scanner.nextLine();
        String data = scanner.nextLine();
        String response = weatherController.checkWeather(cityName, data);
        System.out.println("Twoja pogoda: " + response);
        // todo: provide the implementation
        // todo: use WeatherController.java
    }

    private void showAddedPlaces() {
        String showPlaces = localizationController.showAddedPlaces();

        showPlaces = showPlaces.replaceAll("\\[", "\n")
                .replaceAll("\\{", "\n")
                .replaceAll("\\}", "")
                .replaceAll("\\]", "");

        System.out.println("Zapisane lokalizacje: " + showPlaces);
    }

    //sprawdzic czy zmiana na public nie powoduje zamieszania w kodzie
    public void addLocalization() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj nazwe państwa: ");
        String countryName = scanner.nextLine();
        System.out.print("Podaj region: ");
        String region = scanner.nextLine();
        System.out.print("Podaj nazwe miasta: ");
        String citiName = scanner.nextLine();
        System.out.println("Podaj długosc geograficzną");
        int longitude = scanner.nextInt();
        System.out.println("Podaj szerokość geograficzną");
        int latitude = scanner.nextInt();
        try {
            String response = localizationController.addLocalization(citiName, region, countryName, latitude, longitude);
            System.out.println("Lokalizacja została zapisana: " + response);
        } catch (BadRequestException e) {
            System.out.println("Lokalizacja nie została dodana: " + e.getMessage());
        }
    }
}
