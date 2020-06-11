package com.lxr.leetcode;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * <p>
 * eg1.
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * <p>
 * eg2.
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 */
public class SearchA2DMatrix {

    /**
     * 0ms     100.00% Run time
     * 39.2MB  70.73% Memory
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;

        // 二分法

        int first = 1;
        int last = row * column;

        int[] firstIndex = calculatorIndex(first, column);
        int[] lastIndex = calculatorIndex(last, column);

        // 运气好的情况
        if (target == matrix[firstIndex[0]][firstIndex[1]]
                || target == matrix[lastIndex[0]][lastIndex[1]]) {
            return true;
        }

        while (target > matrix[firstIndex[0]][firstIndex[1]]
                && target < matrix[lastIndex[0]][lastIndex[1]]) {
            // 尽头
            if (last - first <= 1) {
                return false;
            }

            // 中间值
            int[] middleIndex = calculatorIndex((first + last) / 2, column);

            if (target == matrix[middleIndex[0]][middleIndex[1]]) {
                return true;
            } else if (target > matrix[middleIndex[0]][middleIndex[1]]) {
                first = (first + last) / 2;
            } else {
                last = (first + last) / 2;
            }
        }

        return false;
    }

    /**
     * 计算第num个数字的索引
     *
     * @param num
     * @param column
     * @return
     */
    private int[] calculatorIndex(int num, int column) {
        int[] index = new int[2];
        index[0] = (num / column) + (num % column == 0 ? 0 : 1) - 1;
        index[1] = (num % column == 0 ? column : (num % column)) - 1;

        return index;
    }

}
