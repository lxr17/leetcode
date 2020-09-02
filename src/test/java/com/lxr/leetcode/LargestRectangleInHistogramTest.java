package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2020/9/2.
 */
public class LargestRectangleInHistogramTest {

    @Test
    public void largestRectangleArea() {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};

        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(heights));
    }

}
