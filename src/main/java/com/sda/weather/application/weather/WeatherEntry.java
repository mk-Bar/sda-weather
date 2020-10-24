package com.sda.weather.application.weather;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@Table(name = "weatherTable")
public class WeatherEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String cityName;
    LocalDate localDate;
    String windSpeed;

    public WeatherEntry(String cityName, LocalDate localDate, String windSpeed) {
        this.cityName = cityName;
        this.localDate = localDate;
        this.windSpeed = windSpeed;
    }
}
