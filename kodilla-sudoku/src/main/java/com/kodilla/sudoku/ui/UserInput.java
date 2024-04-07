package com.kodilla.sudoku.ui;

import com.kodilla.sudoku.board.SudokuRow;

import java.util.Scanner;

public enum UserInput {
    INSTANCE;
    static Scanner scanner = new Scanner(System.in);
    static boolean gameEnded = false;

    public static boolean getAnswerOnEnd() {
        if (gameEnded) {
            System.out.println("Goodbye");
            return false;
        }
        while (true) {
            try {
                System.out.println("Resolve next sudoku? Enter Y\n" +
                                   "Quit the program? Enter N");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("Y"))
                    return true;
                else if (choice.equalsIgnoreCase("N"))
                    return false;
            } catch (Exception e) {
                System.out.println("wrong choice, try again");
            }
        }
    }

    public static void welcomeInfo() {
        System.out.println("Welcome in Sudoku game player.");
    }

    public static void chooseOption() {
        System.out.println("""
                Choose option:
                1 - play classic (9x9) game
                2 - play small (3x3) game
                3 - exit
                """);
        boolean validChoice = false;
        while (!validChoice) {
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        SudokuRow.setRow(9); validChoice = true; break;
                        case 2:
                            SudokuRow.setRow(3); validChoice = true; break;
                            case 3: scanner.close();
                            validChoice = true;
                            gameEnded = true;
                            break;
                    default:
                        System.out.println("wrong choice, try again");
                }
            } catch (Exception e) {
                System.out.println("wrong choice, try again");
            }
        }
    }

    public static boolean isGameEnded() {
        return gameEnded;
    }

    public static void printer(String toPrint) {
        System.out.println(toPrint);
    }
}
