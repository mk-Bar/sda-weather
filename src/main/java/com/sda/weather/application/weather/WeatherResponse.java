package com.sda.weather.application.weather;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class WeatherResponse {

    List<ListItem> list = new ArrayList<>();

    @Data
    public static class ListItem {
        String dt_txt;
        String dt;
        Wind wind;

        @Data
        public static class Wind {
            String speed;
            String deg;
        }
    }
}
