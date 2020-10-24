package com.sda.weather.application.localization;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@Table(name = "localizationTable")
public class LocalizationEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String citiName;
    String region;
    @Column(nullable = false)
    String countryName;
    int latitude;
    int longitude;
//    Instant createdDate;


    public LocalizationEntry(final String citiName, final String region, final String countryName, final int latitude, final int longitude) {
        this.citiName = citiName;
        this.region = region;
        this.countryName = countryName;
//        this.createdDate = createdDate;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
