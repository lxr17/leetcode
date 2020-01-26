package com.lxr.leetcode;

import org.junit.Test;

import java.util.Random;

/**
 * Created by lanxingren on 2020-01-26.
 */
public class RotateImageTest {

    @Test
    public void rotate() {
        int[][] matrix = createMatrix(6);
        printMatrix(matrix);

        System.out.println();

        new RotateImage().rotate(matrix);
        printMatrix(matrix);
    }

    public int[][] createMatrix(int n) {
        int[][] ans = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = new Random().nextInt(10);
            }
        }

        return ans;
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
