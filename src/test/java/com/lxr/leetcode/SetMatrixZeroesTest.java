package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2020/6/11.
 */
public class SetMatrixZeroesTest {

    @Test
    public void setZeroes() {
        int[][] matrix = new int[2][3];
        matrix[0] = new int[]{1, 1, 1};
        matrix[1] = new int[]{0, 1, 2};

        new SetMatrixZeroes().setZeroes(matrix);

        System.out.println(matrix);
    }

}
