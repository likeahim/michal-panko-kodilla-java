package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ContextConfiguration
public class BoardTaskTestSuite {

    @Test
    void testAddingTask() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        String doneTask = "done task";

        //When
        boolean toDoTask = board.getToDoList().getTasks().add("to do task");
        board.getInProgressList().getTasks().add("in progress task");
        board.getDoneList().getTasks().add("done task");

        //Then
        assertTrue(toDoTask);
        assertEquals(1, board.getInProgressList().getTasks().size());
        System.out.println("expected done task - added: " + doneTask);
    }
}
