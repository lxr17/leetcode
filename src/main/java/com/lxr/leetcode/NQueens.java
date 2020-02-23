package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * <p>
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * <p>
 * eg.
 * Input: 4
 * Output: [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */
public class NQueens {

    /**
     * 6ms     37.28% Run time
     * 41MB    5.41% Memory
     */
    public List<List<String>> solveNQueens(int n) {
        List<String> puzzle = new ArrayList<>();

        char[] chs = new char[n];
        Arrays.fill(chs, '.');

        for (int i = 0; i < n; i++) {
            puzzle.add(new String(chs));
        }

        return fillRest(puzzle, 0);
    }

    /**
     * 根据已填的来继续填写剩下的部分
     *
     * @param puzzle 已填写部分
     * @param index  已填写完成的行数
     * @return
     */
    private List<List<String>> fillRest(List<String> puzzle, int index) {
        List<List<String>> ans = new ArrayList<>();

        // 填写第index行
        for (int i = 0; i < puzzle.size(); i++) {
            if (canFill(puzzle, index, i)) {
                List<String> newPuzzle = new ArrayList<>(puzzle);

                char[] chs = new char[puzzle.size()];
                Arrays.fill(chs, '.');
                chs[i] = 'Q';
                newPuzzle.set(index, new String(chs));

                if (index < puzzle.size() - 1) {
                    List<List<String>> part = fillRest(newPuzzle, index + 1);
                    ans.addAll(part);
                } else {
                    ans.add(newPuzzle);
                }
            }
        }

        return ans;
    }

    /**
     * 判断索引(x, y)是否可放置皇后
     *
     * @param puzzle
     * @param x
     * @param y
     * @return
     */
    private boolean canFill(List<String> puzzle, int x, int y) {
        // 先比较纵向
        for (int i = 0; i < x; i++) {
            if ('Q' == puzzle.get(i).charAt(y)) {
                return false;
            }
        }

        // 再比较斜向
        int k = 1;
        while ((x - k >= 0 && y - k >= 0) || (x - k >= 0 && y + k <= puzzle.size() - 1)) {
            // 当左上角坐标存在
            if (x - k >= 0 && y - k >= 0 && 'Q' == puzzle.get(x - k).charAt(y - k)) {
                return false;
            }

            // 当右上角坐标存在
            if (x - k >= 0 && y + k <= puzzle.size() - 1 && 'Q' == puzzle.get(x - k).charAt(y + k)) {
                return false;
            }

            ++k;
        }

        return true;
    }
}
