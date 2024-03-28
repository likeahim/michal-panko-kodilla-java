package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {

    private static final double A = 10;
    private static final double B = 5;

    @Test
    void testCalculations() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);

        //When
        double addResult = calculator.add(A, B);
        double subResult = calculator.sub(A, B);
        double mulResult = calculator.mul(A, B);
        double divResult = calculator.div(A, B);

        //Then
        assertEquals(15.0, addResult);
        assertEquals(5.0, subResult);
        assertEquals(50.0, mulResult);
        assertEquals(2.0, divResult);
    }
}
