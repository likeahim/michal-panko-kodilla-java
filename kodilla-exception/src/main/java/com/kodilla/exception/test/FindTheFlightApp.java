package com.kodilla.exception.test;

public class FindTheFlightApp {
    public static void main(String[] args) {
        FlightFinder flightFinder = new FlightFinder();
        Flight flight = new Flight("PUJ", "LAX");

        try {
            boolean flightAccess = flightFinder.findFlight(flight);
            System.out.println("Access confirmation to " + flight.getArrivalAirport() + ": " + flightAccess);
        } catch (RouteNotFoundException e) {
            System.out.println("There is no flight to " + flight.getArrivalAirport() + " in out offer.");
        }
    }
}
