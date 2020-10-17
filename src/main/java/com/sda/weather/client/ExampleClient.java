package com.sda.weather.client;

import com.sda.weather.application.Controller;

import java.util.Scanner;

public class ExampleClient {
private final Controller controller=new Controller();
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
        controller.addLocalization("");
    }
}
