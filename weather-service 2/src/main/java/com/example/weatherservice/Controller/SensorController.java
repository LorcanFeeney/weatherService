package com.example.weatherservice.Controller;

import com.example.weatherservice.DAO.Sensor;
import com.example.weatherservice.Repository.SensorRepository;
import com.example.weatherservice.Repository.WeatherDataRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {
    private final SensorRepository sensorRepository;
    private final WeatherDataRepository weatherDataRepository;

    public SensorController(SensorRepository sensorRepository, WeatherDataRepository weatherDataRepository) {
        this.sensorRepository = sensorRepository;
        this.weatherDataRepository = weatherDataRepository;
    }

    // API endpoint for creating a new sensor
    @PostMapping
    public Sensor createSensor(@RequestBody Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    // API endpoint for retrieving all sensors
    @GetMapping
    public  List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }
}
