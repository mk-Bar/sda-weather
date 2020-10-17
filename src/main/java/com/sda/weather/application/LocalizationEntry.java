package com.sda.weather.application;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
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
    Instant createdDate;
    int latitude;
    int longitude;
}
