package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2020/6/4.
 */
public class MinimumPathSumTest {

    @Test
    public void minPathSum() {
        int[][] grid = new int[12][];
        grid[0] = new int[]{0, 2, 2, 6, 4, 1, 6, 2, 9, 9, 5, 8, 4, 4};
        grid[1] = new int[]{0, 3, 6, 4, 5, 5, 9, 7, 8, 3, 9, 9, 5, 4};
        grid[2] = new int[]{6, 9, 0, 7, 2, 2, 5, 6, 3, 1, 0, 4, 2, 5};
        grid[3] = new int[]{3, 8, 2, 3, 2, 8, 8, 7, 5, 9, 6, 3, 4, 5};
        grid[4] = new int[]{4, 0, 1, 3, 9, 2, 0, 1, 6, 7, 9, 2, 8, 9};
        grid[5] = new int[]{6, 2, 7, 9, 0, 9, 5, 2, 7, 5, 1, 4, 4, 7};
        grid[6] = new int[]{9, 8, 3, 3, 0, 6, 8, 0, 8, 8, 3, 5, 7, 3};
        grid[7] = new int[]{7, 7, 4, 5, 9, 1, 5, 0, 2, 2, 2, 1, 7, 4};
        grid[8] = new int[]{5, 1, 3, 4, 1, 6, 0, 4, 3, 8, 4, 3, 9, 9};
        grid[9] = new int[]{0, 6, 4, 9, 4, 1, 5, 5, 4, 2, 5, 7, 4, 0};
        grid[10] = new int[]{0, 1, 6, 6, 4, 9, 2, 7, 8, 2, 1, 3, 3, 7};
        grid[11] = new int[]{8, 4, 9, 9, 2, 3, 8, 6, 6, 5, 4, 1, 7, 9};

        System.out.println(new MinimumPathSum().minPathSum(grid));
    }

}
