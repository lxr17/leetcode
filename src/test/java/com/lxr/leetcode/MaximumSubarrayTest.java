package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2020/3/15.
 */
public class MaximumSubarrayTest {

    @Test
    public void maxSubArray() {
        int[] nums = new int[]{3};

        int ans = new MaximumSubarray().maxSubArray(nums);

        System.out.println(ans);
    }

}
