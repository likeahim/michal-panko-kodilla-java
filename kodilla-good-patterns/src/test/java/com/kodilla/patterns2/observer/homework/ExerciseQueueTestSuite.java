package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseQueueTestSuite {

    @Test
    void testUpdate() {
        //Given
        ExerciseQueue johnsQueue = new ExerciseQueue("John Smith");
        ExerciseQueue marksQueue = new ExerciseQueue("Mark Plasky");
        ExerciseQueue edwinsQueue = new ExerciseQueue("Edwin Saar");
        Exercise exercise1_1 = new Exercise("Exercise 1_1");
        Exercise exercise1_5 = new Exercise("Exercise 1_5");
        Exercise exercise1_7 = new Exercise("Exercise 1_7");
        Exercise exercise2_3 = new Exercise("Exercise 2_3");
        Exercise exercise2_5 = new Exercise("Exercise 2_5");
        Exercise exercise3_2 = new Exercise("Exercise 3_2");
        Mentor jannick = new Mentor("Jannick");
        Mentor maria = new Mentor("Maria");
        johnsQueue.registerObserver(jannick);
        marksQueue.registerObserver(jannick);
        edwinsQueue.registerObserver(maria);

        //When
        johnsQueue.addExercise(exercise1_1);
        johnsQueue.addExercise(exercise1_5);
        johnsQueue.addExercise(exercise2_3);
        marksQueue.addExercise(exercise1_7);
        marksQueue.addExercise(exercise2_3);
        edwinsQueue.addExercise(exercise1_5);
        edwinsQueue.addExercise(exercise2_3);
        edwinsQueue.addExercise(exercise2_5);
        edwinsQueue.addExercise(exercise3_2);

        //Then
        assertEquals(5, jannick.getExcerciseToCheck());
        assertEquals(4, maria.getExcerciseToCheck());
        assertEquals(3, johnsQueue.getExercises().size());
    }

}