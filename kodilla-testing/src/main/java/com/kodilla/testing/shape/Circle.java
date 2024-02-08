package com.kodilla.testing.shape;

public class Circle implements Shape {

    private double radius;

    public Circle() {
    }

    @Override
    public String getShapeName() {
        return "Circle";
    }

    @Override
    public double getField() {
        return Math.PI * Math.pow(radius, 2);
    }
}
