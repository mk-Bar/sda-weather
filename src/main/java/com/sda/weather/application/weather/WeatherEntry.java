package com.sda.weather.application.weather;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


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
    //    LocalDateTime localDate;
    String localDate;
    String windSpeed;

    public WeatherEntry(String cityName, String localDate, String windSpeed) {
        this.cityName = cityName;
        this.localDate = localDate;
        this.windSpeed = windSpeed;
    }
}
