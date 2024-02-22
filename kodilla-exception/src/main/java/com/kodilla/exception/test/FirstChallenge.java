package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if (b==0) {
            throw new ArithmeticException();
        }
        return a / b;
    }
    /** this main can throw an ArithmeticException!!
     * @param args
     */
    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();
        try {
            double result = firstChallenge.divide(3, 0);
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("you cannot divide by 0 " + e);
        } finally {
            System.out.println("Mathematics rules are simple, but necessary");
        }

    }
}
