package com.kodilla.good.patterns.challenges.airparrot;

import com.kodilla.good.patterns.challenges.airparrot.logic.MainService;

public class FlightApplication {
    public static void main(String[] args) {
        MainService service = new MainService();
        service.launchService();
    }
}
