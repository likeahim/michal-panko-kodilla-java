package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    private static TaskFactory taskFactory = new TaskFactory();

    @Test
    void testFactoryShoppingTask() {
        //Given
        Task task = taskFactory.createTask(TaskFactory.SHOPPING);
        //When
        task.executeTask();
        //Then
        assertTrue(task.isTaskExecuted());
        assertEquals(task.getTaskName(), "shopping");
    }

    @Test
    void testFactoryPaintingTask() {
        //Given
        Task task = taskFactory.createTask(TaskFactory.PAINTING);
        //When
        //Then
        assertFalse(task.isTaskExecuted());
        assertEquals(task.getTaskName(), "painting");
    }

    @Test
    void testFactoryDrivingTask() {
        //Given
        Task task = taskFactory.createTask(TaskFactory.DRIVING);
        //When
        boolean taskJustCreated = task.isTaskExecuted();
        task.executeTask();
        //Then
        assertTrue(task.isTaskExecuted());
        assertFalse(taskJustCreated);

    }
}
