package com.kodilla.rps.shapes;

import java.util.Objects;

public final class Paper implements Shape {

    private final String name = "Paper";
    private final char displayImage = 'p';

    private Scissors bully;
    private Rock victim;

    public String getName() {
        return name;
    }

    public char getDisplayImage() {
        return displayImage;
    }

    public Scissors getBully() {
        return new Scissors();
    }

    @Override
    public Rock getVictim() {
        return new Rock();
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
