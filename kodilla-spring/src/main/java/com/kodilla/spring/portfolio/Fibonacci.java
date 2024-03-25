package com.kodilla.spring.portfolio;

public class Fibonacci {
    public static void main(String[] args) {
        int fiboNumber = 3;

        long result = getFibonacci(fiboNumber);
        System.out.println("F" + fiboNumber + " in Fibonacci cycle is: " + result);
        }

    private static long getFibonacci(int fiboNumber) {
        long result;
        long prevNumber = 1;
        if (fiboNumber <= 1) {
            return fiboNumber;
        }
        result = 1;
        for (int i = 2; i < fiboNumber; i++) {
            long adder = result;
            result += prevNumber;
            prevNumber = adder;

    }
        return result;
    }
}
