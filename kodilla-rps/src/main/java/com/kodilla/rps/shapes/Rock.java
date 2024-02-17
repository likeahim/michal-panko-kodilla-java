package com.kodilla.rps.shapes;

public final class Rock implements Shape {

    private final String name = "Rock";
    private final char displayImage = '\u1F48';
    private final Shape bully = new Paper();
    private final Shape victim = new Scissors();


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
