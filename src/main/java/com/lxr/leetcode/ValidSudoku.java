package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * + Each row must contain the digits 1-9 without repetition.
 * + Each column must contain the digits 1-9 without repetition.
 * + Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * <p>
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * <p>
 * eg1.
 * Input:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * <p>
 * eg2.
 * Input:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 * modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * <p>
 * note:
 * + A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * + Only the filled cells need to be validated according to the mentioned rules.
 * + The given board contain only digits 1-9 and the character '.'.
 * + The given board size is always 9x9.
 */
public class ValidSudoku {

    /**
     * 2ms     90.46% Run time
     * 42.8MB  97.10% Memory
     */
    public boolean isValidSudoku(char[][] board) {
        // 遍历每一行
        for (int i = 0; i < 9; i++) {
            List<Character> chars = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                if ('.' == board[i][j]) {
                    continue;
                }

                if (!chars.contains(board[i][j])) {
                    chars.add(board[i][j]);
                } else {
                    return false;
                }
            }
        }

        // 遍历每一列
        for (int i = 0; i < 9; i++) {
            List<Character> chars = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                if ('.' == board[j][i]) {
                    continue;
                }

                if (!chars.contains(board[j][i])) {
                    chars.add(board[j][i]);
                } else {
                    return false;
                }
            }
        }

        // 遍历每一3*3矩阵
        int x = 0;
        int y = 0;
        while (x <= 6 && y <= 6) {
            if (contain(board, x, y)) {
                return false;
            } else {
                if (y == 6) {
                    x = x + 3;
                    y = 0;
                } else {
                    y = y + 3;
                }
            }
        }

        return true;
    }

    /**
     * 行从索引x开始，列从索引y开始的一个3*3矩阵是否重复
     *
     * @param board
     * @param x
     * @param y
     * @return
     */
    private boolean contain(char[][] board, int x, int y) {
        List<Character> chars = new ArrayList<>();

        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if ('.' == board[i][j]) {
                    continue;
                }

                if (!chars.contains(board[i][j])) {
                    chars.add(board[i][j]);
                } else {
                    return true;
                }
            }
        }

        return false;
    }

}
