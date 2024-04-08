package com.kodilla.sudoku.board;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {

    List<SudokuRow> rows = new ArrayList<>();

    public SudokuBoard() {
        for (int i = 0; i < SudokuRow.getRow(); i++) {
            rows.add(new SudokuRow());
        }
    }

    public List<SudokuRow> getRows() {
        return rows;
    }

    @Override
    public String toString() {
        String board = "";
        if (SudokuRow.getRow() == 3)
            board += "    1 2 3\n";
        else
            board = "    1 2 3 4 5 6 7 8 9\n";
        int index = 1;
        for (SudokuRow row : rows) {
            board += index + ") " + row.toString();
            index++;
        }
        return board;
    }
}
