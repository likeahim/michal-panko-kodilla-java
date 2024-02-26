package com.kodilla.exception.exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInputer {
    public static Scanner scanner = new Scanner(System.in);

    public void giveNumber() throws InputMismatchException, NumberOutOfABoundException {
        System.out.println("Give number from 10 to 50 (inclusive):");
        try {
            String number = scanner.nextLine();
            int numberAsInt = Integer.parseInt(number);
            if (numberAsInt > 10 && numberAsInt < 50)
                System.out.println("your correct number: " + number);
            else
                throw new NumberOutOfABoundException();
        } catch (NumberOutOfABoundException e) {
            System.out.println("your number is out of a bound");
        } catch (NumberFormatException e) {
            System.out.println("your input is no number");
        }
    }
}
