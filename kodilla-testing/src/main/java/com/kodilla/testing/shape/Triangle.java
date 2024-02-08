package com.kodilla.testing.shape;

public class Triangle implements Shape {

    private double base;
    private double height;

    public Triangle() {
    }

    @Override
    public String getShapeName() {
        return "Triangle";
    }

    @Override
    public double getField() {
        return base * height / 2;
    }
}
