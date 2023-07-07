package com.example.weatherservice.DAO;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "measurements")
public class WeatherData {

    @Column(name = "sensor_id", nullable = false)
    private int sensor;

    @Id
    @Column(name = "time", nullable = false)
    private LocalDateTime timestamp;

    @Column(name = "location")
    private String location;

    @Column(name="temperature",nullable = false)
    private Double temperature;

    @Column(name="rainfall",nullable = false)
    private Double rainfall;

    @Column(name="wind_speed", nullable = false)
    private Double windSpeed;

}
