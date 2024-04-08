package com.kodilla.sudoku.ui;

import com.kodilla.sudoku.board.SudokuRow;
import com.kodilla.sudoku.logic.SudokuGame;

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
                        SudokuRow.setRow(9);
                        validChoice = true;
                        break;
                    case 2:
                        SudokuRow.setRow(3);
                        validChoice = true;
                        break;
                    case 3:
                        scanner.close();
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

    public static String nextMove() {
        String input;
        while (true) {
            System.out.println("""
                    Enter next number [x,y,number]
                    or
                    type "SUDOKU" to try to resolve this game
                    """);
            input = scanner.nextLine();
            if (validateInput(input))
                return input;
            else {
                falseInput();
                input = "";
            }
        }
    }

    private static boolean validateInput(String input) {
        if (input.equalsIgnoreCase("sudoku"))
            return true;
        try {
            String[] split = input.split(",");
            SudokuGame.setCurrentX(Integer.parseInt(split[0])-1);
            SudokuGame.setCurrentY(Integer.parseInt(split[1])-1);
            SudokuGame.setCurrentNumber(Integer.parseInt(split[2]));
            if (SudokuGame.getCurrentX() >= SudokuRow.getRow() ||
                SudokuGame.getCurrentY() >= SudokuRow.getRow() ||
                SudokuGame.getCurrentNumber() > 9 ||
                SudokuGame.getCurrentNumber() < 1)
                return false;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void occupiedCellInfo() {
        System.out.println("This cell is already occupied");
    }

    public static void falseInput() {
        System.out.println("false input, try again");
    }
}
