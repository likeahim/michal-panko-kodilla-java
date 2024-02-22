package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {

        SecondChallenge challenge = new SecondChallenge();
        double x = 2;
        double y = 1.5;

        try {
            System.out.println(challenge.probablyIWillThrowException(x, y));
        } catch (Exception e) {
            System.out.println("exception catched " + e);
        } finally {
            System.out.println("x=" + x + "; y=" + y);
        }
    }
}
