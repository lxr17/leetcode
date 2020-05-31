package com.lxr.leetcode;

/**
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.
 * <p>
 * eg.
 * Input: 3
 * Output:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class SpiralMatrixII {

    /**
     * 0ms     100.00% Run time
     * 37.3MB  8.33% Memory
     */
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];

        // 圈数-1
        int circle = 0;

        // 当前数字
        int currentNum = 1;

        while (n - circle - 1 - circle >= 0) {
            // 四个点坐标
            int leftTopX = circle;
            int leftTopY = circle;
            int leftBottomX = n - circle - 1;
            int leftBottomY = circle;
            int rightTopX = circle;
            int rightTopY = n - circle - 1;
            int rightBottomX = n - circle - 1;
            int rightBottomY = n - circle - 1;

            // 左上→右上
            for (int y = leftTopY; y <= rightTopY; y++) {
                ans[leftTopX][y] = currentNum++;
            }

            // 右上→右下
            for (int x = rightTopX + 1; x <= rightBottomX; x++) {
                ans[x][rightTopY] = currentNum++;
            }

            // 右下→左下
            for (int y = rightBottomY - 1; y >= leftBottomY; y--) {
                ans[rightBottomX][y] = currentNum++;
            }

            // 左下→左上(注意这里没有=)
            for (int x = leftBottomX - 1; x > leftTopX; x--) {
                ans[x][leftBottomY] = currentNum++;
            }

            circle++;
        }

        return ans;
    }

}
