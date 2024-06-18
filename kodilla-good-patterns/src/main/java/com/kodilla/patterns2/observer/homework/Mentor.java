package com.kodilla.patterns2.observer.homework;

public class Mentor implements ObserverMt {
    private final String name;
    private int excerciseToCheck;

    public Mentor(String name) {
        this.name = name;
    }

    @Override
    public void update(ExerciseQueue queue) {
        System.out.println(">>> MENTOR " + name);
        try {
            System.out.println(queue.getStudent() + " has sent new exercise to check: " +
                               queue.getExercises().peekLast().getName() + " <<<");
            excerciseToCheck++;
        } catch (NullPointerException e) {
            System.out.println(name + " has nothing to check <<<");
        }
    }

    public String getName() {
        return name;
    }

    public int getExcerciseToCheck() {
        return excerciseToCheck;
    }
}
