package com.sda.weather.application.weather;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@Table(name = "weatherTable")
public class WeatherEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String citiname;
    String dt_txt;
    String windSpeed;


    public WeatherEntry(String citiname, final String dt_txt, final String windSpeed) {
        this.citiname = citiname;
        this.dt_txt = dt_txt;
        this.windSpeed = windSpeed;

    }
}
