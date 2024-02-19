package com.kodilla.rps.shapes;

import java.util.List;
import java.util.Objects;

public final class Paper implements Shape {
    private final String name = "Paper";
    private final char displayImage = '\u270B';

    public String getName() {
        return name;
    }

    public char getDisplayImage() {
        return displayImage;
    }

    public List<Shape> getBullies() {
        return List.of(new Scissors(), new Lizard());
    }

    public List<Shape> getVictims() {
        return List.of(new Rock(), new Spock());
    }

    @Override
    public String toString() {
        return name + " " + displayImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paper paper = (Paper) o;
        return displayImage == paper.displayImage && Objects.equals(name, paper.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, displayImage);
    }
}
