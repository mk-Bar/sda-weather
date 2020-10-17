package com.sda.weather.client;

import com.sda.weather.application.LocalizationController;

import java.util.Scanner;

public class ExampleClient {
    private final LocalizationController controller = new LocalizationController();

    public void runClientInterface() {
        System.out.println("Twoja aplikacja została uruchomiona");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu aplikacji Weather. Określ co chcesz zrobić: ");
            System.out.println("1. Dodaj lokalizację do bazy danych");
            System.out.println("2. Wyświetl aktualnie dodane lokalizacje");
            System.out.println("3. Pobierz wartości pogodowe");
            System.out.println("0. Zamknij aplikację");

            int response = scanner.nextInt();

            switch (response) {
                case 1:
                    addLocalization();
                    break;
                case 2:
                    showAddedPlaces();
                    break;
                case 3:
                    getWeatherParameters();
                case 0:
                    System.out.println("Twoja aplikacja jest zamykana");
                    return;
            }
        }
    }

    private void getWeatherParameters() {
    }

    private void showAddedPlaces() {
    }

    private void addLocalization() {
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
        String response = LocalizationController.addLocalization(citiName, region, countryName, latitude, longitude);
    }
}
