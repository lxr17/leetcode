package com.lxr.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by lanxingren on 2020/6/2.
 */
public class UniquePathsIITest {

    @Test
    public void uniquePathsWithObstacles() {
        int[][] grid = new int[5][5];

        grid[0] = new int[]{0, 0, 1, 0, 0};
        grid[1] = new int[]{0, 0, 0, 0, 0};
        grid[2] = new int[]{0, 0, 0, 0, 0};
        grid[3] = new int[]{0, 0, 0, 0, 0};
        grid[4] = new int[]{0, 0, 0, 0, 0};

        System.out.println(new UniquePathsII().uniquePathsWithObstacles(grid));
    }

}
