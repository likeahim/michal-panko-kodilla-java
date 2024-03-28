package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task {

    private final String taskName;
    private final String color;
    private final String whatToPaint;
    private boolean isDone;

    public PaintingTask(String taskName, String color, String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
        isDone = false;
    }

    @Override
    public void executeTask() {
        if (!isTaskExecuted()) {
            System.out.println("Starting " + taskName + " for " + whatToPaint +
                               "\nin color " + color);
            isDone = true;
        } else
            System.out.println(taskName + " already done.\n "
                               + whatToPaint + " painted in " + color);
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return isDone;
    }
}
