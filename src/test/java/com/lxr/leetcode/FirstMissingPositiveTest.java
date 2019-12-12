package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2019-12-12.
 */
public class FirstMissingPositiveTest {

    @Test
    public void firstMissingPositive() {
        int[] nums = new int[]{1,2,3};

        int ans = new FirstMissingPositive().firstMissingPositive(nums);

        System.out.println(ans);

    }
}
