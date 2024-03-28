package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task {
    private final String taskName;
    private final String where;
    private final String using;
    private boolean isDone;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
        isDone = false;
    }

    @Override
    public void executeTask() {
        if (!isTaskExecuted()) {
            System.out.println(taskName + " to " + where + ", using " + using);
            isDone = true;
        } else
            System.out.println("already been there, checked");
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
