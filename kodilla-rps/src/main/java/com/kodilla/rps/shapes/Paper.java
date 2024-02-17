package com.kodilla.rps.shapes;

public final class Paper implements Shape {

    private final String name = "Paper";
    private final char displayImage = '\u20E2';

    private final Shape bully = new Scissors();
    private final Shape victim = new Rock();

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
