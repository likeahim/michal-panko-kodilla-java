package com.kodilla.good.patterns.challenges.airparrot.ui;

import com.kodilla.good.patterns.challenges.airparrot.airports.Airport;
import com.kodilla.good.patterns.challenges.airparrot.logic.MainService;

import java.util.List;
import java.util.Scanner;

public class Display {

    private Scanner scanner = new Scanner(System.in);

    public static void noSuchAirport() {
        System.out.println("We don't have this Airport in our offer");
    }

    public int giveNumber() {
        showOption();
        while (true) {
            try {
                int option = scanner.nextInt();
                scanner.nextLine();
                return option;
            } catch (Exception e) {
                System.out.println("no such a option, try again");
            }
        }

    }

    private void showOption() {
        System.out.println("""
                Enter number to choose option:
                1 - find departure flights from airport
                2 - find arrival flights to airport
                3 - find indirect flight
                4 - show partner airports
                0 - close
                """);
    }

    public String giveNameOfAirport(int i) {
        if (i == 1) {
            System.out.println("Enter name of airport to display departures");
        } else {
            System.out.println("Enter name of airport to display arrivals");
        }

        return scanner.nextLine().toUpperCase();
    }

    public String giveIndirecteDeparture() {
        System.out.println("Indirect flight: \n" +
                           "enter departure airport shortcut:");
        return scanner.nextLine().toUpperCase();

    }

    public String giveIndirecteArrival() {
        System.out.println("enter arrival airport shortcut:");
        return scanner.nextLine().toUpperCase();
    }

    public void displayChoosenOption(int option) {
        switch(option) {
            case 1 :
                System.out.println("All departures:"); break;
            case 2 :
                System.out.println("All arrivals:"); break;
            case 3 :
                System.out.println("Indirect flight possible thru"); break;
            case 4 :
                System.out.println("All partner airports:"); break;
            case 0 : MainService.setOption(-1); scanner.close();
        }
    }

    public void showAirports(List<Airport> airports) {
        airports.stream()
                .forEach(System.out::println);
    }

    public void displayOnClose() {
        System.out.println("goodbye");
    }
}
