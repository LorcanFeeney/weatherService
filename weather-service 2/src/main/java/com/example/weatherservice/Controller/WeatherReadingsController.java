package com.example.weatherservice.Controller;

import com.example.weatherservice.DAO.Sensor;
import com.example.weatherservice.DAO.WeatherData;
import com.example.weatherservice.Repository.WeatherDataRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/weatherData")
public class WeatherReadingsController {
    private final WeatherDataRepository weatherDataRepository;

    public WeatherReadingsController(WeatherDataRepository weatherDataRepository) {
        this.weatherDataRepository = weatherDataRepository;
    }

    // API endpoint to retrieve weather data for a specific location and sensor type
    @GetMapping("/{location}")
    public List<WeatherData> getWeatherData(
            @PathVariable String location
            ) {
        return weatherDataRepository.findByLocation(location);
    }
}
