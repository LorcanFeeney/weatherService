package com.example.weatherservice.Controller;

import com.example.weatherservice.DAO.Sensor;
import com.example.weatherservice.Repository.SensorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class SensorControllerTest {
    @InjectMocks
    private SensorController sensorController;

    @Mock
    private SensorRepository sensorRepository;

    @Test
    public void testCreateSensor() {
        Sensor sensor = new Sensor();
        sensor.setName("Sensor A");
        sensor.setLocation("Location A");

        Mockito.when(sensorRepository.save(Mockito.any(Sensor.class))).thenReturn(sensor);

        Sensor createdSensor = sensorController.createSensor(sensor);

        assertNotNull(createdSensor);
        assertEquals("Sensor A", createdSensor.getName());
        assertEquals("Location A", createdSensor.getLocation());

        Mockito.verify(sensorRepository, Mockito.times(1)).save(Mockito.any(Sensor.class));
    }

    @Test
    public void testGetAllSensors() {
        List<Sensor> sensorList = new ArrayList<>();
        Sensor sensorOne = new Sensor();
        sensorOne.setName("Sensor A");
        sensorOne.setLocation("Location A");
        Sensor sensorTwo = new Sensor();
        sensorTwo.setName("Sensor B");
        sensorTwo.setLocation("Location B");
        sensorList.add(sensorOne);
        sensorList.add(sensorTwo);

        Mockito.when(sensorRepository.findAll()).thenReturn(sensorList);

        List<Sensor> result = sensorController.getAllSensors();

        assertNotNull(result);
        assertEquals(2, result.size());

        Mockito.verify(sensorRepository, Mockito.times(1)).findAll();
    }
}
