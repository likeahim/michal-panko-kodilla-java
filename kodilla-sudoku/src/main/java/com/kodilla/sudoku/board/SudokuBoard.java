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

    @Override
    public String toString() {
        String board = "";
        for (SudokuRow row : rows) {
            board += row.toString();
        }
        return board;
    }
}
