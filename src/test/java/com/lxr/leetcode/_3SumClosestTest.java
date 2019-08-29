package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by he_jhua on 2019/4/3.
 */
public class _3SumClosestTest {

    @Test
    public void threeSumClosest() {
//        int[] nums = new int[]{0, 1, 2};
//        int[] nums = new int[]{-1,2,1,-4};
//        int[] nums = new int[]{1, 1, 1, 1};
//        int[] nums = new int[]{1, 1, -1, -1, 3};
        int[] nums = new int[]{1, 2, 4, 8, 16, 32, 64, 128};
        int target = 82;

        int ans = new _3SumClosest().threeSumClosest(nums, target);

        System.out.println(ans);
    }

}
