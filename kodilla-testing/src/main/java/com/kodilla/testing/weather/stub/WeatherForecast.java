package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculateAverageTemperature(Map<String, Double> tempMap) {
        double average = 0;
        for (Double value : tempMap.values()) {
            average += value;
        }

        return average / tempMap.size();
    }

    public double calculateMedianTemperature(Map<String, Double> tempMap) {
        double median = 0;
        Map<String, Double> sortedMap = new TreeMap<>();
        sortedMap.putAll(tempMap);
        List<Double> listOfTemp = new ArrayList<>(sortedMap.values());
        if (listOfTemp.size() % 2 == 0) {
            Double bigger = listOfTemp.get(listOfTemp.size() / 2);
            Double smaller = listOfTemp.get(listOfTemp.size() / 2 - 1);
            median = Math.rint((bigger + smaller) / 2);
        } else {
            median = listOfTemp.get(listOfTemp.size() / 2);
        }
        return median;
    }
}
