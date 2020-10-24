package com.sda.weather.application.weather;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class WeatherResponse {

    List<ListItem> list = new ArrayList<>();
    List<Wind> wind = new ArrayList<>();

    @Data
    public static class ListItem {

        String dt_txt;
        //                String speed="test";
//        String windSpeed=getWindSpeed();
        String dt;
    }

    @Data
    public static class Wind {

        String speed;
        String deg;
    }
}
