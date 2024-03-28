package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task {

    private final String taskName;
    private final String whatToBuy;
    private final double quantity;
    private boolean isDone;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
        isDone = false;
    }


    @Override
    public void executeTask() {
        if (!isTaskExecuted()) {
            System.out.println("executing task " + taskName + "\n" +
                               "to buy: " + whatToBuy + " | x " + quantity);
            isDone = true;
        } else
            System.out.println("Task " + taskName + " already done\n" +
                               whatToBuy + "[" + quantity + "] bought");
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
