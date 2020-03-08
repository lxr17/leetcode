package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * <p>
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 * <p>
 * eg.
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
 * [
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
 */
public class NQueensII {

    /**
     * 8ms     9.39% Run time
     * 40.5MB  8.70% Memory
     */
    public int totalNQueens(int n) {
        int[][] source = new int[n][n];

        List<int[][]> ans = fillRest(source, 0);

        return ans.size();
    }

    /**
     * 填写从index行开始的剩余行
     *
     * @param source 已填写部分
     * @param index  需要填写的行数
     * @return 所有的结果
     */
    private List<int[][]> fillRest(int[][] source, int index) {
        List<int[][]> ans = new ArrayList<>();

        for (int i = 0; i < source.length; i++) {
            if (canFill(source, index, i)) {
                int[][] temp = clone(source);
                temp[index][i] = 1;

                if (index == source.length - 1) {
                    ans.add(temp);
                } else {
                    ans.addAll(fillRest(temp, index + 1));
                }
            }
        }

        return ans;
    }

    /**
     * 拷贝数组
     *
     * @param source
     * @return
     */
    private int[][] clone(int[][] source) {
        int[][] newArray = new int[source.length][source[0].length];

        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[0].length; j++) {
                newArray[i][j] = source[i][j];
            }
        }

        return newArray;
    }

    /**
     * 判断坐标(x, y)可否填写
     *
     * @param source
     * @param x
     * @param y
     * @return
     */
    private boolean canFill(int[][] source, int x, int y) {
        // 先比较纵向
        for (int i = 0; i < x; i++) {
            if (source[i][y] == 1) {
                return false;
            }
        }

        // 再比较斜向
        int k = 1;
        while ((x - k >= 0 && y - k >= 0) || (x - k >= 0 && y + k < source.length)) {
            // 左上角坐标存在
            if (x - k >= 0 && y - k >= 0 && source[x - k][y - k] == 1) {
                return false;
            }

            // 右上角坐标存在
            if (x - k >= 0 && y + k < source.length && source[x - k][y + k] == 1) {
                return false;
            }

            ++k;
        }

        return true;
    }

}
