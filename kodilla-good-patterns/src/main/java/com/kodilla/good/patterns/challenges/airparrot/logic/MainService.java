package com.kodilla.good.patterns.challenges.airparrot.logic;

import com.kodilla.good.patterns.challenges.airparrot.airports.Airport;
import com.kodilla.good.patterns.challenges.airparrot.airports.MainAirportService;
import com.kodilla.good.patterns.challenges.airparrot.ui.Display;

import java.util.ArrayList;
import java.util.List;

public class MainService {

    private FlightSearchEngine fse = new FlightSearchEngine(new MainAirportService());
    private Display display = new Display();
    private static int option = 0;

    public void launchService () {
        while (option >= 0) {
            List<Airport> airports = chooseTypeOfAction(display.giveNumber());
            display.displayChoosenOption(option);
            display.showAirports(airports);
        }
        display.displayOnClose();
    }

    private List<Airport> chooseTypeOfAction(int number) {
        List<Airport> airports = new ArrayList<>();
        switch (number) {
            case 1 : airports = fse.getAllDepartureFlightsFromAirport(display.giveNameOfAirport(1));
            break;
            case 2 : airports = fse.getAllArrivalFlightsFromAirport(display.giveNameOfAirport(2));
            break;
            case 3 : airports = fse.getIndirectFlight(display.giveIndirecteDeparture(), display.giveIndirecteArrival());
            break;
            case 4 : airports = fse.getMas().getAllAirports();
            break;
        }
        option = number;
        return airports;
    }

    public static void setOption(int option) {
        MainService.option = option;
    }
}
