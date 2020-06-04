package com.lxr.leetcode;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * eg.
 * Input:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum {

    /**
     * 2ms     87.92% Run time
     * 42.1MB  85.13% Memory
     */
    public int minPathSum(int[][] grid) {
        // 反思：如果需要获取的不仅仅是一个数字，而是一个路径的话，那需要新建一个grid[][]，并且其中的每个格子都存入路径

        int row = grid.length;
        int column = grid[0].length;

        // 每个格子填入到此格子的最短路径
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                // 从上往下
                int top = -1;
                // 从左往右
                int left = -1;

                if (i - 1 >= 0) {
                    top = grid[i - 1][j];
                }

                if (j - 1 >= 0) {
                    left = grid[i][j - 1];
                }

                // 判断哪条路之和小，走小的那条路
                grid[i][j] = grid[i][j] + minNum(left, top);
            }
        }

        return grid[row - 1][column - 1];
    }

    /**
     * 获取最小的非负数
     */
    private int minNum(int left, int top) {
        if (left == -1 && top == -1) {
            return 0;
        }

        if (left == -1) {
            return top;
        }

        if (top == -1) {
            return left;
        }

        if (left > top) {
            return top;
        } else {
            return left;
        }
    }

}
