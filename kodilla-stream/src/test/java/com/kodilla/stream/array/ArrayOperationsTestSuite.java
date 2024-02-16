package com.kodilla.stream.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {
    @DisplayName("shows average of numbers")
    @Test
    void testGetAverage(){
        //Given
        int[] numbers = {1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 3};

        //When
        double average = ArrayOperations.getAverage(numbers);

        //Then
        assertEquals(2, average);
    }
}
