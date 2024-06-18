package com.kodilla.patterns2.observer.homework;

public class Exercise {
    private final String name;
    private boolean isCorrect;

    public Exercise(String name) {
        this.name = name;
        isCorrect = false;
    }

    public String getName() {
        return name;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
