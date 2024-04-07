package com.kodilla.sudoku.logic;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.ui.UserInput;

public class SudokuGame {

    SudokuBoard board;


    public void play() {
        UserInput.welcomeInfo();
        UserInput.chooseOption();
        if (!UserInput.isGameEnded()) {
            board = new SudokuBoard();
            UserInput.printer(board.toString());
        }
    }

    public boolean resolveSudoku() {
        return UserInput.getAnswerOnEnd();
    }
}
