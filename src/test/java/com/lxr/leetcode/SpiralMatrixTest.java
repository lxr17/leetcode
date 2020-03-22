package com.lxr.leetcode;

import org.junit.Test;

import java.util.List;

/**
 * Created by lanxingren on 2020/3/22.
 */
public class SpiralMatrixTest {

    @Test
    public void spiralOrder() {
//        int[][] matrix = new int[3][4];
//
//        matrix[0] = new int[]{1, 2, 3, 4};
//        matrix[1] = new int[]{5, 6, 7, 8};
//        matrix[2] = new int[]{9, 10, 11, 12};
        int[][] matrix = new int[][]{};

        List<Integer> ans = new SpiralMatrix().spiralOrder(matrix);

        for (int x : ans) {
            System.out.print(x + " ");
        }

    }

}
