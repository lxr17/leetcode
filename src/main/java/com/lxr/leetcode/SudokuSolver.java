package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * <p>
 * A sudoku solution must satisfy all of the following rules:
 * + Each of the digits 1-9 must occur exactly once in each row.
 * + Each of the digits 1-9 must occur exactly once in each column.
 * + Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * Empty cells are indicated by the character '.'.
 * <p>
 * Note:
 * + The given board contain only digits 1-9 and the character '.'.
 * + You may assume that the given Sudoku puzzle will have a single unique solution.
 * + The given board size is always 9x9.
 */
public class SudokuSolver {

    /**
     * 4ms    89.71% Run time
     * 36.7MB 22.81% Memory
     */
    public void solveSudoku(char[][] board) {
        trySolveSudoku(board);
    }

    /**
     * 1. 填充所有的唯一数单元格
     * 2. 对于非唯一数单元格的所有可选数字做尝试
     *
     * @return true 解决成功 | false 解决失败
     */
    private boolean trySolveSudoku(char[][] board) {
        // 已经填入格子的总数
        int hasFilledLength = 0;
        // 上一次计算的值
        int last = 0;

        // 不停的循环找出每一个有唯一解格子的结果
        while (hasFilledLength != 81) {
            hasFilledLength = 0;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if ('.' == board[i][j]) {
                        List<Character> list = findAllPossibleSolution(board, i, j);

                        // 这个格子是唯一解
                        if (list.size() == 1) {
                            board[i][j] = list.get(0);
                            hasFilledLength++;
                        } else if (list.size() == 0) {// 此时这个格子无解，因此是之前的猜想错了，直接返回false
                            return false;
                        }
                    } else {
                        hasFilledLength++;
                    }
                }
            }

            // 如果填完了所有的唯一数单元格，跳出循环
            if (hasFilledLength == last) {
                break;
            }
            last = hasFilledLength;
        }

        // 此时完全填充完毕
        if (hasFilledLength == 81) {
            return true;
        }

        // 继续填充剩余的格子
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ('.' == board[i][j]) {
                    List<Character> list = findAllPossibleSolution(board, i, j);
                    for (int k = 0; k < list.size(); k++) {
                        char[][] tempBoard = cloneArr(new char[9][9], board);
                        tempBoard[i][j] = list.get(k);
                        boolean correct = trySolveSudoku(tempBoard);

                        if (correct) {
                            cloneArr(board, tempBoard);
                            return true;
                        }
                    }

                    // 如果循环了所有的条件之后这个格子还未填写，就证明之前的猜测数字是错误的
                    if ('.' == board[i][j]) {
                        return false;
                    }
                }
            }
        }

        return false;
    }

    /**
     * 深度复制一份数独（重写该方法的原因是Arrays.copyOf()与clone()方法都无法深度复制
     *
     * @param arr
     * @return
     */
    private char[][] cloneArr(char[][] cloneArr, char[][] arr) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cloneArr[i][j] = arr[i][j];
            }
        }

        return cloneArr;
    }

    /**
     * 构建一个1-9的字符集合
     */
    private List<Character> createNineList() {
        List<Character> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            list.add((char) ('0' + i));
        }

        return list;
    }

    /**
     * 找到该格子的所有可能解
     */
    private List<Character> findAllPossibleSolution(char[][] board, int i, int j) {
        List<Character> list = createNineList();

        // 剔除不可能的数字
        for (int k = 0; k < 9; k++) {
            if ('.' != board[i][k]) {
                list.remove((Character) board[i][k]);
            }

            if ('.' != board[k][j]) {
                list.remove((Character) board[k][j]);
            }

            if ('.' != board[i / 3 * 3 + k / 3][j / 3 * 3 + k % 3]) {
                list.remove((Character) board[i / 3 * 3 + k / 3][j / 3 * 3 + k % 3]);
            }
        }

        return list;
    }

}
