package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ExerciseQueue implements ExObservable {
    private final List<ObserverMt> observers;
    private final ArrayDeque<Exercise> exercises;
    private final String student;

    public ExerciseQueue(String student) {
        observers = new ArrayList<>();
        exercises = new ArrayDeque<>();
        this.student = student;
    }

    public void addExercise(Exercise exercise) {
        exercises.addLast(exercise);
        notifyObservers();
    }

    @Override
    public void registerObserver(ObserverMt mentor) {
        observers.add(mentor);
    }

    @Override
    public void removeObserver(ObserverMt mentor) {
        removeObserver(mentor);
    }

    @Override
    public void notifyObservers() {
        for (ObserverMt mentor : observers) {
            mentor.update(this);
        }
    }

    public ArrayDeque<Exercise> getExercises() {
        return exercises;
    }

    public String getStudent() {
        return student;
    }
}
