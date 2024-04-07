package com.kodilla.sudoku;

import com.kodilla.sudoku.logic.SudokuGame;

public class Sudoku {
    public static void main(String[] args) {
        boolean gameFinished = true;
        while (gameFinished) {
            SudokuGame game = new SudokuGame();
            game.play();
            gameFinished = game.resolveSudoku();
        }
    }
}
