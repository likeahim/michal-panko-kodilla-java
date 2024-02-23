package com.kodilla.exception.test;

import java.util.HashMap;

public class FlightFinder {

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        HashMap<String, Boolean> mapWithFlights = new HashMap<>();
        fillFlightMap(mapWithFlights);
        String keyToFind = flight.getArrivalAirport();
        Boolean arrivalValue = mapWithFlights.get(flight.getArrivalAirport());
        if (mapWithFlights.containsKey(keyToFind) && arrivalValue)
            return mapWithFlights.get(keyToFind);
        else
            throw new RouteNotFoundException();
    }

    private static void fillFlightMap(HashMap<String, Boolean> mapWithFlights) {
        mapWithFlights.put("JFK", true);
        mapWithFlights.put("BLZ", true);
        mapWithFlights.put("LAX", false);
        mapWithFlights.put("PUJ", false);
        mapWithFlights.put("SXF", true);
    }
}
