package com.kodilla.sudoku.logic;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.ui.UserInput;

public class SudokuGame {

    SudokuBoard board;
    String terminate = "";
    private static int currentX;
    private static int currentY;
    private static int currentNumber;


    public void play() {
        UserInput.welcomeInfo();
        UserInput.chooseOption();
        if (!UserInput.isGameEnded()) {
            board = new SudokuBoard();
            UserInput.printer(board.toString());
            while (!terminate.equalsIgnoreCase("SUDOKU")) {
                terminate = UserInput.nextMove();
                if (terminate.equalsIgnoreCase("SUDOKU"))
                    tryToResolve(board);
                else
                    uptadeBoard(terminate);
            }
        }
    }

    private void uptadeBoard(String terminate) {

        if (board.getRows().get(currentX).getCols().get(currentY).getValue() != -1)
            UserInput.occupiedCellInfo();
        else if (!checkComplianceWithRules())
            UserInput.falseInput();
        else {
            board.getRows().get(currentX).getCols().get(currentY).setValue(currentNumber);
            board.getRows().get(currentX).getCols().get(currentY).getPossibleValues().remove(currentNumber);
        }
        UserInput.printer(board.toString());
    }

    //List possibleValues should be checked in this method, in smaller squares, horizontal and vertical lines
    private boolean checkComplianceWithRules() {
        for (int x = 0; x < board.getRows().size(); x += 3) {
            for (int y = 0; y < board.getRows().size(); y += 3) {
                if (!checkSquare(x, y))
                    return false;
            }
        }
        if (!checkHorizontalLine())
            return false;
        if (!checkVerticalLine())
            return false;
        return true;
    }

    private boolean checkVerticalLine() {
        for (int y = 0; y < board.getRows().size(); y++) {
            for (int x = 0; x < board.getRows().size(); x++) {
                if (!board.getRows().get(x).getCols().get(y).getPossibleValues().contains(currentNumber))
                    return false;
            }
        }
        return true;
    }

    private boolean checkHorizontalLine() {
        for (int x = 0; x < board.getRows().size(); x++) {
            for (int y = 0; y < board.getRows().size(); y++) {
                if (board.getRows().get(x).getCols().get(y).getValue() == currentNumber)
                    return false;
            }
        }
        return true;
    }

    private boolean checkSquare(int x, int y) {
        for (int i = 0; i < 3; i++) {
            if (board.getRows().get(x).getCols().get(y).getValue() == currentNumber)
                return false;
            x += 1;
            y += 1;
        }
        return true;
    }

    private void tryToResolve(SudokuBoard board) {

    }

    public boolean resolveSudoku() {
        return UserInput.getAnswerOnEnd();
    }

    public static int getCurrentX() {
        return currentX;
    }

    public static void setCurrentX(int currentX) {
        SudokuGame.currentX = currentX;
    }

    public static int getCurrentY() {
        return currentY;
    }

    public static void setCurrentY(int currentY) {
        SudokuGame.currentY = currentY;
    }

    public static int getCurrentNumber() {
        return currentNumber;
    }

    public static void setCurrentNumber(int currentNumber) {
        SudokuGame.currentNumber = currentNumber;
    }
}
