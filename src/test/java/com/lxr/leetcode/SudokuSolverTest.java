package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2019-11-06.
 */
public class SudokuSolverTest {

    @Test
    public void solveSudoku() {

        char[][] quest = createSudoku2();

        new SudokuSolver().solveSudoku(quest);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(quest[i][j] + " ");
            }

            System.out.println();
        }
    }

    private char[][] createSudoku() {
        char[][] sudoku = new char[9][];

        sudoku[0] = new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        sudoku[1] = new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        sudoku[2] = new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        sudoku[3] = new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        sudoku[4] = new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        sudoku[5] = new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        sudoku[6] = new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        sudoku[7] = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        sudoku[8] = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};

        return sudoku;
    }

    private char[][] createSudoku1() {
        char[][] sudoku = new char[9][];

        sudoku[0] = new char[]{'.', '.', '9', '7', '4', '8', '.', '.', '.'};
        sudoku[1] = new char[]{'7', '.', '.', '.', '.', '.', '.', '.', '.'};
        sudoku[2] = new char[]{'.', '2', '.', '1', '.', '9', '.', '.', '.'};
        sudoku[3] = new char[]{'.', '.', '7', '.', '.', '.', '2', '4', '.'};
        sudoku[4] = new char[]{'.', '6', '4', '.', '1', '.', '5', '9', '.'};
        sudoku[5] = new char[]{'.', '9', '8', '.', '.', '.', '3', '.', '.'};
        sudoku[6] = new char[]{'.', '.', '.', '8', '.', '3', '.', '2', '.'};
        sudoku[7] = new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '6'};
        sudoku[8] = new char[]{'.', '.', '.', '2', '7', '5', '9', '.', '.'};

        return sudoku;
    }

    private char[][] createSudoku2() {
        char[][] sudoku = new char[9][];

        sudoku[0] = new char[]{'1', '.', '.', '.', '7', '.', '.', '3', '.'};
        sudoku[1] = new char[]{'8', '3', '.', '6', '.', '.', '.', '.', '.'};
        sudoku[2] = new char[]{'.', '.', '2', '9', '.', '.', '6', '.', '8'};
        sudoku[3] = new char[]{'6', '.', '.', '.', '.', '4', '9', '.', '7'};
        sudoku[4] = new char[]{'.', '9', '.', '.', '.', '.', '.', '5', '.'};
        sudoku[5] = new char[]{'3', '.', '7', '5', '.', '.', '.', '.', '4'};
        sudoku[6] = new char[]{'2', '.', '3', '.', '.', '9', '1', '.', '.'};
        sudoku[7] = new char[]{'.', '.', '.', '.', '.', '2', '.', '4', '3'};
        sudoku[8] = new char[]{'.', '4', '.', '.', '8', '.', '.', '.', '9'};

        return sudoku;
    }

//            ["1","6","9","8","7","5","4","3","2"]
//            ["8","3","4","6","2","1","7","9","5"]
//            ["5","7","2","9","4","3","6","1","8"]
//            ["6","2","5","1","3","4","9","8","7"]
//            ["4","9","8","2","6","7","3","5","1"]
//            ["3","1","7","5","9","8","2","6","4"]
//            ["2","8","3","4","5","9","1","7","6"]
//            ["9","5","6","7","1","2","8","4","3"]
//            ["7","4","1","3","8","6","5","2","9"]

}
