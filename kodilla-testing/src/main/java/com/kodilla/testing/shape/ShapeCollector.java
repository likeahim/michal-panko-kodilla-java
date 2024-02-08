package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapes = new ArrayList<>();
    public void addShape(Shape shape) {
        shapes.add(shape);
    }
    public boolean removeShape(Shape shape) {
        boolean result = false;
        if(shapes.contains(shape)) {
            shapes.remove(shape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int n) {
    return shapes.get(n);
    }

    public String showFigures() {
        String allShapes = "";
        for (Shape shape : shapes) {
            allShapes += shape.getShapeName();
            allShapes += " ";
        }
        allShapes = allShapes.substring(0, allShapes.length() - 1);
        return allShapes;
    }

    public List<Shape> getShapes() {
        return shapes;
    }
}
