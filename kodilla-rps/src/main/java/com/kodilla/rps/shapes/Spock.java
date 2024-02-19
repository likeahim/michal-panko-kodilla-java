package com.kodilla.rps.shapes;

import java.util.List;
import java.util.Objects;

public class Spock implements Shape {
    private final String name = "Spock";
    private final char displayImage = '\u0056';

    public String getName() {
        return name;
    }

    public char getDisplayImage() {
        return displayImage;
    }

    @Override
    public List<Shape> getBullies() {
        return List.of(new Paper(), new Lizard());
    }

    @Override
    public List<Shape> getVictims() {
        return List.of(new Rock(), new Scissors());
    }

    @Override
    public String toString() {
        return name + " " + displayImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spock spock = (Spock) o;
        return displayImage == spock.displayImage && Objects.equals(name, spock.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, displayImage);
    }
}
