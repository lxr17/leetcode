package com.lxr.leetcode;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * <p>
 * eg.
 * Input:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * Output: 6
 */
public class MaximalRectangle {

    /**
     * 13ms     33.89% Run time
     * 41.6MB   99.08% Memory
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int maxRect = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int[] coordinate = new int[]{i, j};

                if (isPossible(matrix, coordinate, maxRect)) {
                    int rect = findMaxRectangle(matrix, coordinate);

                    if (rect > maxRect) {
                        maxRect = rect;
                    }
                }
            }
        }

        return maxRect;
    }

    /**
     * 判断当前坐标可不可能作为顶点
     *
     * @param matrix
     * @param coordinate
     * @param maxRect    目前最大矩形
     * @return
     */
    private boolean isPossible(char[][] matrix, int[] coordinate, int maxRect) {
        // 如果是0不可能为顶点
        if (matrix[coordinate[0]][coordinate[1]] == 0) {
            return false;
        }

        // 如果左边的点为1，则该点也不能为顶点
        if (coordinate[1] - 1 >= 0 && matrix[coordinate[0]][coordinate[1] - 1] == 1) {
            return false;
        }

        // 如果剩余部分最大面积比maxRect还小，则不能为顶点
        if ((matrix.length - coordinate[0]) * (matrix[0].length - coordinate[1]) < maxRect) {
            return false;
        }

        return true;
    }

    /**
     * 以coordinate为左上顶点的最大矩形
     *
     * @param matrix
     * @param coordinate 矩形左上角坐标
     * @return
     */
    private int findMaxRectangle(char[][] matrix, int[] coordinate) {
        // 最大矩形
        int maxRect = 0;

        // height行内的最小宽度
        int minWidth = matrix[0].length;

        // 高度
        int height = 1;

        // 以coordinate为顶点，第height列的首个坐标为1的情况下继续
        while (coordinate[0] + height <= matrix.length
                && matrix[coordinate[0] + height - 1][coordinate[1]] == '1') {
            int width = 0;

            for (int i = coordinate[1]; i < matrix[0].length; i++) {
                // 这里多了一个 `width < minWidth` 是为了减少比较
                if (width < minWidth && matrix[coordinate[0] + height - 1][i] == '1') {
                    width++;
                } else {
                    break;
                }
            }

            // 重置最小宽度
            if (width < minWidth) {
                minWidth = width;
            }

            if (minWidth * height > maxRect) {
                maxRect = minWidth * height;
            }

            height++;
        }

        return maxRect;
    }

}
