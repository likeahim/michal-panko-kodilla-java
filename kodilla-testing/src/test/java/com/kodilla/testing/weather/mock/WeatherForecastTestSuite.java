package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {

    private static Map<String, Double> temperaturesMap = new HashMap<>();

    @Mock
    private Temperatures temperaturesMock;
    @BeforeEach
     void fillTempMap() {
        temperaturesMap.put("Rzeszów", 25.5);
        temperaturesMap.put("Kraków", 26.2);
        temperaturesMap.put("Wrocław", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdańsk", 26.1);
    }
    @Test
    void testCalculateForecastWithMock() {
        //Given
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @Test
    void testCalculateAverageTemperatureWithMock() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        double averageTemp = weatherForecast.calculateAverageTemperature(temperaturesMap);
        when(temperaturesMock.getAverageTemperature()).thenReturn(averageTemp);

        //When
        double average = (25.5 + 26.2 + 24.8 + 25.2 + 26.1) / 5.0;

        //Then
        Assertions.assertEquals(average, averageTemp);
    }

    @Test
    void testCalculateMedianTemperatureWithMoch() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        double medianTemp = weatherForecast.calculateMedianTemperature(temperaturesMap);
        when(temperaturesMock.getMedianTemperature()).thenReturn(medianTemp);

        //When
        double median = 25.5;

        //Then
        Assertions.assertEquals(median, medianTemp);
    }
}