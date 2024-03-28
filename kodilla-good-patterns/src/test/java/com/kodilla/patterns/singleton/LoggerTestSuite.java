package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoggerTestSuite {

    @BeforeAll
    public static void setLogger() {
        logger = Logger.INSTANCE;
    }

    private static Logger logger;
    @Test
    void testGetLastLog() {
        //Given
        //When
        String result = logger.getLastLog();
        //Then
        assertTrue(result.isEmpty());
        assertNotEquals(result, "log");
    }

    @Test
    void testLogAndGetLastLog() {
        //Given
        logger.log("> Task :kodilla-good-patterns:test");
        //When
        String result = logger.getLastLog();
        //Then
        assertEquals(result, "> Task :kodilla-good-patterns:test");
    }
}
