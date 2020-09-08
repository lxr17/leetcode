package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2020/9/8.
 */
public class MaximalRectangleTest {

    @Test
    public void maximalRectangle() {
        char[][] matrix = new char[4][];
        matrix[0] = new char[]{'1', '0', '1', '0', '0'};
        matrix[1] = new char[]{'1', '1', '1', '1', '1'};
        matrix[2] = new char[]{'1', '1', '0', '1', '1'};
        matrix[3] = new char[]{'1', '0', '0', '1', '0'};

        int ans = new MaximalRectangle().maximalRectangle(matrix);

        System.out.println(ans);
    }

}
