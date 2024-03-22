package com.kodilla.good.patterns.challenges.airparrot.logic;

import com.kodilla.good.patterns.challenges.airparrot.airports.Airport;
import com.kodilla.good.patterns.challenges.airparrot.airports.MainAirportService;
import com.kodilla.good.patterns.challenges.airparrot.ui.Display;

import java.util.ArrayList;
import java.util.List;

public class FlightSearchEngine {

    private MainAirportService mas;

    public FlightSearchEngine(MainAirportService mas) {
        this.mas = mas;
    }

    public List<Airport> getAllDepartureFlightsFromAirport(String airportShortcut) {
        List<Airport> departureFlights = new ArrayList<>();
        MainAirportService masRef = mas; // Przekazanie referencji do obiektu mas
        try {
            departureFlights = masRef.getAllAirports().stream()
                    .filter(a -> a.getShortcut().equals(airportShortcut))
                    .flatMap(a -> a.getDepartureAirports().stream())
                    .toList();
        } catch (Exception e) {
            Display.noSuchAirport();
        }
        return departureFlights;
    }

    public List<Airport> getAllArrivalFlightsFromAirport(String airportShortcut) {
        List<Airport> arrivalFlights = new ArrayList<>();
        try {
            arrivalFlights = mas.getAllAirports().stream()
                    .filter(a -> a.getShortcut().equals(airportShortcut))
                    .flatMap(a -> a.getArrivalAirports().stream())
                    .toList();
        } catch (Exception e) {
            Display.noSuchAirport();
        }
        return arrivalFlights;
    }

    public List<Airport> getIndirectFlight(String departurePortShortcut, String arrivalPortShortcut) {
        List<Airport> indirectFlight = new ArrayList<>();
        MainAirportService masRef = mas;
        List<Airport> list = masRef.getAllAirports().stream()
                .filter(a -> a.getShortcut().equals(arrivalPortShortcut))
                .toList();
        Airport arrivalAirport = list.get(0);
        if (getAllDepartureFlightsFromAirport(departurePortShortcut).isEmpty())
            Display.noSuchAirport();
        else {
            indirectFlight = masRef.getAllAirports().stream()
                    .filter(a -> a.getShortcut().equals(departurePortShortcut))
                    .flatMap(a -> a.getDepartureAirports().stream())
                    .filter(a -> a.getDepartureAirports().contains(arrivalAirport))
                    .toList();

        }
        return indirectFlight;
    }

    public MainAirportService getMas() {
        return mas;
    }
}
