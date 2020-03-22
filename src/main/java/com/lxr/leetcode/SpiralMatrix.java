package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * e.g.1
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * <p>
 * e.g.2.
 * Input:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {

    /**
     * 0ms     100.00% Run time
     * 37.7MB  5.21% Memory
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        if (matrix.length == 0) {
            return ans;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        // 一圈圈的输出
        while (top <= bottom && left <= right) {
            // 最后一圈为一行或者一列时
            if (top == bottom) {
                for (int i = left; i <= right; i++) {
                    ans.add(matrix[top][i]);
                }
                break;
            }
            if (left == right) {
                for (int i = top; i <= bottom; i++) {
                    ans.add(matrix[i][left]);
                }
                break;
            }

            // 上
            for (int i = left; i < right; i++) {
                ans.add(matrix[top][i]);
            }

            // 右
            for (int i = top; i < bottom; i++) {
                ans.add(matrix[i][right]);
            }

            // 下
            for (int i = right; i > left; i--) {
                ans.add(matrix[bottom][i]);
            }

            // 左
            for (int i = bottom; i > top; i--) {
                ans.add(matrix[i][left]);
            }

            top++;
            bottom--;
            left++;
            right--;
        }

        return ans;
    }

}
