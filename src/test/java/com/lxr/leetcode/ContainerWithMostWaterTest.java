package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2019-06-11.
 */
public class ContainerWithMostWaterTest {

    @Test
    public void maxArea() {
        int[] iii = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int max = new ContainerWithMostWater().maxArea(iii);

        System.out.println(max);
    }
}
