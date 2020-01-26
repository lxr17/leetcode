package com.lxr.leetcode;

/**
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * Note:
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 * <p>
 * eg1.
 * Given input matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * rotate the input matrix in-place such that it becomes:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * <p>
 * eg2.
 * Given input matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * rotate the input matrix in-place such that it becomes:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 */
public class RotateImage {

    /**
     * 0ms     100.00% Run time
     * 38.5MB  5.77% Memory
     */
    public void rotate(int[][] matrix) {
        // 由外向内，一圈一圈旋转
        // 每一圈的数字一个个的旋转

        // 对1*1及以下数组作特殊处理
        if (matrix.length <= 1) {
            return;
        }

        int start = 0;
        int end = matrix.length - 2;

        while (start <= end) {
            // 旋转第i个数
            for (int i = 0; i <= end - start; i++) {
                int temp = matrix[start][start + i];

                // 旋转
                matrix[start][start + i] = matrix[end + 1 - i][start];
                matrix[end + 1 - i][start] = matrix[end + 1][end + 1 - i];
                matrix[end + 1][end + 1 - i] = matrix[start + i][end + 1];
                matrix[start + i][end + 1] = temp;
            }

            // 下一圈
            ++start;
            --end;
        }
    }

}
