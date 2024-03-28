package com.kodilla.good.patterns.enums.hotel;

public class HotelApp {

    public static void main(String[] args) {
        System.out.println("Accomodation prices:");
        System.out.println("1 single bed room:");
        System.out.println("    - low season: " + Season.LOW.getSingleRoomPrice());
        System.out.println("    - high season: " + Season.HIGH.getSingleRoomPrice());
        System.out.println("    - holiday season: " + Season.HOLIDAY.getSingleRoomPrice());
        System.out.println("1 double bed room:");
        System.out.println("    - low season: " + Season.LOW.getDoubleRoomPrice());
        System.out.println("    - high season: " + Season.HIGH.getDoubleRoomPrice());
        System.out.println("    - holiday season: " + Season.HOLIDAY.getDoubleRoomPrice());
    }
}
