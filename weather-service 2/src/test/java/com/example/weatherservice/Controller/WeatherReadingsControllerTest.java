package com.example.weatherservice.Controller;

import com.example.weatherservice.DAO.Sensor;
import com.example.weatherservice.DAO.WeatherData;
import com.example.weatherservice.Repository.WeatherDataRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class WeatherReadingsControllerTest {
    @InjectMocks
    private WeatherReadingsController weatherDataController;

    @Mock
    private WeatherDataRepository weatherDataRepository;

    @Test
    public void testGetWeatherData() {
        List<WeatherData> weatherDataList = new ArrayList<>();
        WeatherData weatherDataOne = new WeatherData();
        weatherDataOne.setTimestamp(LocalDateTime.now());
        weatherDataOne.setSensor(1);
        weatherDataOne.setRainfall(25.5);
        weatherDataOne.setTemperature(10.0);
        weatherDataOne.setWindSpeed(45.6);

        WeatherData weatherDataTwo = new WeatherData();
        weatherDataTwo.setTimestamp(LocalDateTime.now());
        weatherDataTwo.setSensor(1);
        weatherDataTwo.setRainfall(55.5);
        weatherDataTwo.setTemperature(78.0);
        weatherDataTwo.setWindSpeed(22.1);

        weatherDataList.add(weatherDataOne);
        weatherDataList.add(weatherDataTwo);

        Mockito.when(weatherDataRepository.findByLocation(Mockito.anyString())).thenReturn(weatherDataList);

        List<WeatherData> result = weatherDataController.getWeatherData("Location A");

        assertNotNull(result);
        assertEquals(2, result.size());

        Mockito.verify(weatherDataRepository, Mockito.times(1)).findByLocation(Mockito.anyString());
    }
}
