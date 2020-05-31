package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2020/5/31.
 */
public class SpiralMatrixIITest {

    @Test
    public void generateMatrix() {
        int[][] ans = new SpiralMatrixII().generateMatrix(0);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

}
