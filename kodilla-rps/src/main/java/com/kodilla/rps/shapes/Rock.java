package com.kodilla.rps.shapes;

import java.util.List;
import java.util.Objects;

public final class Rock implements Shape {
    private final String name = "Rock";
    private final char displayImage = '\u270A';

    public String getName() {
        return name;
    }

    public char getDisplayImage() {
        return displayImage;
    }

    @Override
    public List<Shape> getBullies() {
        return List.of(new Paper(), new Spock());
    }

    @Override
    public List<Shape> getVictims() {
        return List.of(new Lizard(), new Scissors());
    }

    @Override
    public String toString() {
        return name + " " + displayImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rock rock = (Rock) o;
        return displayImage == rock.displayImage && Objects.equals(name, rock.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, displayImage);
    }
}
