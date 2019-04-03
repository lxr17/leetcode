package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by he_jhua on 2019/4/3.
 */
public class TwoSumTest {

    @Test
    public void twoSum() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        int[] ans = new TwoSum().twoSum(nums, target);

        System.out.println(String.format("first:%d, second:%d", ans[0], ans[1]));
    }

}
