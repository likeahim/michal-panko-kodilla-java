package com.kodilla.rps.shapes;

import java.util.List;
import java.util.Objects;

public class Lizard implements Shape {
    private final String name = "Lizard";
    private final char displayImage = '\u8734';

    public String getName() {
        return name;
    }

    public char getDisplayImage() {
        return displayImage;
    }

    @Override
    public List<Shape> getBullies() {
        return List.of(new Rock(), new Scissors());
    }

    @Override
    public List<Shape> getVictims() {
        return List.of(new Paper(), new Spock());
    }

    @Override
    public String toString() {
        return name + " " + displayImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lizard lizard = (Lizard) o;
        return displayImage == lizard.displayImage && Objects.equals(name, lizard.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, displayImage);
    }
}
