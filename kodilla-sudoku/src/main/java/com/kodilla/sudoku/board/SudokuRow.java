package com.kodilla.sudoku.board;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private static int row;
    private List<SudokuElement> cols = new ArrayList<>();

    public SudokuRow() {
        for (int i = 0; i < row; i++) {
            cols.add(new SudokuElement());
        }
    }

    public static int getRow() {
        return row;
    }

    public static void setRow(int row) {
        SudokuRow.row = row;
    }

    public List<SudokuElement> getCols() {
        return cols;
    }

    @Override
    public String toString() {
        String top = "";
        top += "|";
        for (int i = 0; i < cols.size(); i++) {
            top += cols.get(i);
            top += "|";
        }
        top += "\n";
        return top;
    }
}
