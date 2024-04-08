package com.kodilla.sudoku.logic;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.SudokuElement;
import com.kodilla.sudoku.board.SudokuRow;
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
            removePossibleValues(currentX, currentY, currentNumber);
        }
        UserInput.printer(board.toString());
    }

    private void removePossibleValues(int coordinateX, int coordinateY, int numberToRemove) {
        for (int y = 0; y < board.getRows().size(); y++) {
            if (board.getRows().get(coordinateX).getCols().get(coordinateY).getPossibleValues().contains(numberToRemove)) {
                board.getRows().get(coordinateX).getCols().get(y).getPossibleValues().remove(Integer.valueOf(numberToRemove));
                board.getRows().get(coordinateX).getCols().get(y).getPossibleValues().add(0);
            }
        }
        for (int x = 0; x < board.getRows().size(); x++) {
            if (board.getRows().get(x).getCols().get(coordinateY).getPossibleValues().contains(numberToRemove)) {
                board.getRows().get(x).getCols().get(coordinateY).getPossibleValues().remove(Integer.valueOf(numberToRemove));
                board.getRows().get(x).getCols().get(coordinateY).getPossibleValues().add(0);
            }
        }
    }

    //List possibleValues should be checked in this method, in smaller squares, horizontal and vertical lines
    private boolean checkComplianceWithRules() {
//        for (int x = 0; x < board.getRows().size(); x += 3) {
//            for (int y = 0; y < board.getRows().size(); y += 3) {
                if (!checkSquare(currentX, currentY, currentNumber))
                    return false;
//            }
//        }
        if (!checkHorizontalLine(currentX, currentNumber))
            return false;
        if (!checkVerticalLine(currentY, currentNumber))
            return false;
        return true;
    }

    private boolean checkVerticalLine(int y, int number) {
            for (int x = 0; x < board.getRows().size(); x++) {
                if (board.getRows().get(x).getCols().get(y).getValue() == number)
                    return false;
            }
        return true;
    }

    private boolean checkHorizontalLine(int x, int number) {
            for (int y = 0; y < board.getRows().size(); y++) {
                if (board.getRows().get(x).getCols().get(y).getValue() == number)
                    return false;
            }
        return true;
    }

    private boolean checkSquare(int x, int y, int number) {
        int deltaX = Math.abs(x - SudokuRow.getRow());
        int deltaY = Math.abs(y - SudokuRow.getRow());
        x = setSquareCoordinate(deltaX);
        y = setSquareCoordinate(deltaY);
        int temp = 0;
        for (int i = x; i < (x + 3); i++) {
            for (int j = y; j < (y + 3); j++) {
                if (board.getRows().get(i).getCols().get(j).getValue() == number) {
                    temp = number;
                }
            }

        }
        return temp == 0;
    }

    private int setSquareCoordinate(int coordinate) {
        if (coordinate <= 3)
            return SudokuRow.getRow() - 3;
        else if (coordinate <= 6)
            return SudokuRow.getRow() - 6;
        else
            return SudokuRow.getRow() - 9;
    }

    private void tryToResolve(SudokuBoard board) {
        SudokuElement element;
        for (int x = 0; x < board.getRows().size(); x++) {
            for (int y = 0; y < board.getRows().size(); y++) {
                element = board.getRows().get(x).getCols().get(y);
                if (element.getValue() == -1) {
                    for (Integer number : element.getPossibleValues()) {
                        if (checkSquare(x, y, number)) {
                            element.setValue(number);
                            removePossibleValues(x, y, number);
                            break;
                        }
                    }
                }
            }
        }
        UserInput.printer(board.toString());
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
