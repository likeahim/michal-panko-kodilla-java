package com.kodilla.testing.shape;

public class Square implements Shape {

    private double sideLength;

    public Square() {
    }

    @Override
    public String getShapeName() {
        return "Square";
    }

    @Override
    public double getField() {
        return Math.pow(sideLength, 2);
    }
}
