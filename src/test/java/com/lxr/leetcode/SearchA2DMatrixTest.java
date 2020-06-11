package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2020/6/11.
 */
public class SearchA2DMatrixTest {

    @Test
    public void searchMatrix() {
//        int[][] matrix = new int[3][4];
//        matrix[0] = new int[]{1, 3, 5, 7};
//        matrix[1] = new int[]{10, 11, 16, 20};
//        matrix[2] = new int[]{23, 30, 34, 50};

        int[][] matrix = new int[1][];
        matrix[0] = new int[0];

        int target = 12;

        System.out.println(new SearchA2DMatrix().searchMatrix(matrix, target));
    }

}
