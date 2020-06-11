package com.lxr.leetcode;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 * <p>
 * eg1.
 * Input:
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * Output:
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * <p>
 * eg2.
 * Input:
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * Output:
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * <p>
 * Follow up:
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
public class SetMatrixZeroes {

    /**
     * 空间复杂度为O(1)的方法
     * <p>
     * 3ms     18.57% Run time
     * 51.1MB  5.77% Memory
     */
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }

        int row = matrix.length;
        int column = matrix[0].length;

        boolean willRowChange = false;
        boolean willColumnChange = false;

        // 先遍历首行首列，判断首行首列需不需要变0
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                willRowChange = true;
                break;
            }
        }
        for (int j = 0; j < column; j++) {
            if (matrix[0][j] == 0) {
                willColumnChange = true;
                break;
            }
        }

        // 遍历每个格子(除了首行首列)，如果该格子为0，则将该格子所在行以及所在列的首个格子变为0
        // 遍历完成后的matrix首行以及首列的值可以确定整个matrix中哪些格子为0
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 变零(先变非首行首列)
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 变零(再变首行首列)
        if (willRowChange) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
        if (willColumnChange) {
            for (int j = 0; j < column; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    /**
     * 空间复杂度为O(mn)的方法
     * <p>
     * 3ms     18.57% Run time
     * 51.2MB  5.00% Memory
     */
    public void setZeroes2(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }

        int row = matrix.length;
        int column = matrix[0].length;

        // change[i][j]代表这个格子是不是0，默认为false
        boolean[][] change = new boolean[row][column];

        // 遍历每个格子
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    // 更改i行
                    for (int m = 0; m < column; m++) {
                        change[i][m] = true;
                    }

                    // 更改j列
                    for (int n = 0; n < row; n++) {
                        change[n][j] = true;
                    }
                }
            }
        }

        // 变零
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (change[i][j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 空间复杂度为O(m+n)的方法
     * <p>
     * 0ms     100.00% Run time
     * 40.7MB  86.37% Memory
     */
    public void setZeroes3(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }

        int row = matrix.length;
        int column = matrix[0].length;

        // rowChange[i]代表这一行是否为0，默认为false
        boolean[] rowChange = new boolean[row];

        // columnChange[i]代表这一列是否为0，默认为false
        boolean[] columnChange = new boolean[column];

        // 遍历每个格子
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    rowChange[i] = true;
                    columnChange[j] = true;
                }
            }
        }

        // 变零
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (rowChange[i] || columnChange[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 空间复杂度为O(n)的方法
     * <p>
     * 1ms     95.76% Run time
     * 40.9MB  65.34% Memory
     */
    public void setZeroes4(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }

        int row = matrix.length;
        int column = matrix[0].length;

        // columnChange[i]代表这一列是否为0，默认为false
        boolean columnChange[] = new boolean[column];

        // 代表这一行需不需要变零
        boolean willChange;

        // 遍历每个格子
        for (int i = 0; i < row; i++) {
            willChange = false;
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    willChange = true;
                    columnChange[j] = true;
                }
            }

            // 这行变为零
            if (willChange) {
                for (int j = 0; j < column; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 变零
        for (int j = 0; j < column; j++) {
            if (columnChange[j]) {
                for (int i = 0; i < row; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
