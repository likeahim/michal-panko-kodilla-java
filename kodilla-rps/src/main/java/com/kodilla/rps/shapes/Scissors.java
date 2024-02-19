package com.kodilla.rps.shapes;

import java.util.List;
import java.util.Objects;

public class Scissors implements Shape {
    private final String name = "Scissors";
    private final char displayImage = '\u270C';

    public String getName() {
        return name;
    }

    public char getDisplayImage() {
        return displayImage;
    }

    @Override
    public List<Shape> getBullies() {
        return List.of(new Spock(), new Rock());
    }

    @Override
    public List<Shape> getVictims() {
        return List.of(new Paper(), new Lizard());
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
