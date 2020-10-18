package com.sda.weather.application;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class WeatherResponse {

    List<ListItem> list = new ArrayList<>();

    @Data
    public static class ListItem {
        String dt_txt;
    }
}
