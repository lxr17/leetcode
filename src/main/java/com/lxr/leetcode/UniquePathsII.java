package com.lxr.leetcode;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * Note: m and n will be at most 100.
 * <p>
 * eg.
 * Input:
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 */
public class UniquePathsII {

    /**
     * 0ms    100.00% Run time
     * 37.8MB   100.00% Memory
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 如果'Start'为障碍物，则一共有0种路径
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // 行数
        int row = obstacleGrid.length;
        // 列数
        int column = obstacleGrid[0].length;

        // 遍历每一个坐标，并将每个坐标填入到该坐标一共有的路径数
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                // 从'Start'出发，即到[0, 0]一共有1种路径
                if (i == 0 && j == 0) {
                    obstacleGrid[0][0] = 1;
                    continue;
                }

                // 如果当前坐标是障碍物，则被堵住了，因此到达该坐标一共有0种路径
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                    continue;
                }

                // 主要思路：任何一个坐标都是从上或者从左过来的，因此到该坐标的路径数为上和左的路径数之和
                int left = j - 1 >= 0 ? obstacleGrid[i][j - 1] : 0;
                int up = i - 1 >= 0 ? obstacleGrid[i - 1][j] : 0;
                obstacleGrid[i][j] = left + up;
            }
        }

        // 'Finish'坐标处的值即为所需结果
        return obstacleGrid[row - 1][column - 1];
    }

}
