package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2019-12-20.
 */
public class TrappingRainWaterTest {

    @Test
    public void trap() {
        int[] input = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        int[] input = new int[]{4, 2, 3};
//        int[] input = new int[]{1, 7, 8};
//        int[] input = new int[]{9, 2, 9, 3, 2, 2, 1, 4, 8};
        int xxx = new TrappingRainWater().trap(input);
        System.out.println(xxx);
    }

}
