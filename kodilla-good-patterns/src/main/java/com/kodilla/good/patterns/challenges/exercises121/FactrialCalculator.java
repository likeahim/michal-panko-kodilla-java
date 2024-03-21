package com.kodilla.good.patterns.challenges.exercises121;

import java.util.Random;

public class FactrialCalculator {
    public static void main(String[] args) {
        Random random = new Random();
        int number = random.nextInt(10);
        System.out.println("Factorial of " + number + " equals: " + getFactorial(number));
    }

    private static long getFactorial(int number) {
        int result = 1;
        if (number == 0)
            return 1;
        else if (number < 0)
            throw new ArithmeticException("no factorial for negative number");
        else {
            for (int starter = 2; starter <= number; starter++) {
                result = result * starter;
            }
        }
        return result;
    }
}
