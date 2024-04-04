package com.kodilla.spring.portfolio;

public class Fibonacci {
    public static void main(String[] args) {
        int fiboNumber = 7;

        long result = getFibonacci(fiboNumber);
        System.out.println("F" + fiboNumber + " in Fibonacci cycle is: " + result);
        int recFib = fib(7);
        System.out.println("Recurent: " + recFib);
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

    public static int fib(int n) {
        if(n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}

