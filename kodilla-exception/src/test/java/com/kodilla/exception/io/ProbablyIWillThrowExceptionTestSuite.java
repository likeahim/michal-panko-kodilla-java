package com.kodilla.exception.io;

import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProbablyIWillThrowExceptionTestSuite {
    SecondChallenge challenge = new SecondChallenge();
    double x;
    double y;

    @Nested
    @DisplayName("Throwing exception tests")
    class ThrowingExceptionTests {

        @BeforeEach
        void beforeEach() {
            System.out.println("test success if throws exception for values x and y");
        }

        @Test
        void testIfThrowsExceptionBorderValuesOne() {
            //Given
            x = 2;
            y = 1;

            //When & then
            assertThrows(Exception.class, () -> challenge.probablyIWillThrowException(x, y));
        }

        @Test
        void testIfThrowsExceptionBorderValuesTwo() {
            //Given
            double x = 0.5;
            double y = 1;

            //When & then
            assertThrows(Exception.class, () -> challenge.probablyIWillThrowException(x, y));
        }

        @Test
        void testIfThrowsExceptionBorderValuesThree() {
            //Given
            double x = 1.5;
            double y = 1.5;

            //When & then
            assertThrows(Exception.class, () -> challenge.probablyIWillThrowException(x, y));
        }
    }

    @Nested
    class NoExceptionTests {

        @BeforeEach
        void beforeEach() {
            System.out.println("test success if throws no exception");
        }
        @Test
        void noExceptionTest() {
            //Given
            x = 1.5;
            y = 3;

            //when & then
            assertDoesNotThrow(() -> challenge.probablyIWillThrowException(1.5, 2));
        }
    }
}