package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2019-11-06.
 */
public class ValidSudokuTest {

    @Test
    public void isValidSudoku() {
        char[][] sodoku = createSudoku();

        boolean isValid = new ValidSudoku().isValidSudoku(sodoku);

        System.out.println(isValid);
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

}
