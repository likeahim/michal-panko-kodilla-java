package com.kodilla.good.patterns.challenges.food2door.producers;

import java.util.Scanner;

public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static int putOtherAmount(int inStore) {
        while(true) {
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("false amount, try again, available amount of product: " + inStore);
            }
        }
    }
}
