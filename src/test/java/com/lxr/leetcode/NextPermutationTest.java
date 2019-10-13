package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2019-10-13.
 */
public class NextPermutationTest {

    @Test
    public void nextPermutation() {
        int[] nums = new int[]{1, 2, 3, 4, 3, 2, 1};

        new NextPermutation().nextPermutation(nums);

        System.out.println(nums);
    }

}
