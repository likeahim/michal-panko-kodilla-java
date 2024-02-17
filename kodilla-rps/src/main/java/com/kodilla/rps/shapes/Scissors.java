package com.kodilla.rps.shapes;

public class Scissors implements Shape {

    private final String name = "Scissors";
    private final char displayImage = '\u2704';

    private final Shape bully = new Rock();
    private final Shape victim = new Paper();


    public String getName() {
        return name;
    }

    public char getDisplayImage() {
        return displayImage;
    }

    public Shape getBully() {
        return bully;
    }

    @Override
    public Shape getVictim() {
        return victim;
    }

    @Override
    public String toString() {
        return name + " " + displayImage;
    }
}
