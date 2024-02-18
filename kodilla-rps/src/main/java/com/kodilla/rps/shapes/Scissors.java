package com.kodilla.rps.shapes;

import java.util.Objects;

public class Scissors implements Shape {

    private final String name = "Scissors";
    private final char displayImage = 's';

    private Rock bully;
    private Paper victim;


    public String getName() {
        return name;
    }

    public char getDisplayImage() {
        return displayImage;
    }

    public Rock getBully() {
        return new Rock();
    }

    @Override
    public Paper getVictim() {
        return new Paper();
    }

    @Override
    public String toString() {
        return name + " " + displayImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scissors scissors = (Scissors) o;
        return displayImage == scissors.displayImage && Objects.equals(name, scissors.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, displayImage);
    }
}
