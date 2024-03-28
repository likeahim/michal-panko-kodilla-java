package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {

    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public Task createTask(final String taskType) {
        return switch (taskType) {
            case SHOPPING -> new ShoppingTask("shopping", "high shoes", 1.0);
            case PAINTING -> new PaintingTask("painting", "green", "bedroom");
            case DRIVING -> new DrivingTask("driving", "work", "scooter");
            default -> null;
        };
    }
}
