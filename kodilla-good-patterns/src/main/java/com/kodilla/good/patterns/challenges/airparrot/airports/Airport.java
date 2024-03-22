package com.kodilla.good.patterns.challenges.airparrot.airports;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Airport {

    private List<Airport> departureAirports;
    private List<Airport> arrivalAirports;
    private String name;
    private String shortcut;

    public Airport(String NAME, String SHORTCUT) {
        this.name = NAME;
        this.shortcut = SHORTCUT;
        departureAirports = new ArrayList<>();
        arrivalAirports = new ArrayList<>();
    }

    boolean addDepartureAirport(Airport airport) {
        return departureAirports.add(airport);
    }

    boolean removeDepartureAirport(Airport airport) {
        return departureAirports.remove(airport);
    }

    boolean addArrivalAirport(Airport airport) {
        return arrivalAirports.add(airport);
    }

    boolean removeArrivalAirport(Airport airport) {
        return arrivalAirports.remove(airport);
    }

    void addSeveralAirports(List<Airport> airports) {
        departureAirports.addAll(airports);
        arrivalAirports.addAll(airports);
    }

    public List<Airport> getDepartureAirports() {
        return departureAirports;
    }

    public List<Airport> getArrivalAirports() {
        return arrivalAirports;
    }

    public String getName() {
        return name;
    }

    public String getShortcut() {
        return shortcut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(shortcut, airport.shortcut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, shortcut);
    }

    @Override
    public String toString() {
        return "Airport: " + name + " [" + shortcut + "]";
    }
}
