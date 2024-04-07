package com.kodilla.sudoku.board;

import java.util.Arrays;
import java.util.List;

public class SudokuElement {

    private int value;
    public static int EMPTY = -1;
    private List<Integer> possibleValues = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

    public SudokuElement() {
        this.value = EMPTY;
    }

    public int getValue() {
        return value;
    }

    public static int getEMPTY() {
        return EMPTY;
    }

    public List<Integer> getPossibleValues() {
        return possibleValues;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        if (value == -1)
            return " ";
        else
            return String.valueOf(value);
    }
}
