package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2019-10-25.
 */
public class FindFirstAndLastPositionOfElementInSortedArrayTest {

    @Test
    public void searchRange() {
//        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
//        int target = 6;
        int[] nums = new int[]{1};
        int target = 0;

        int[] ans = new FindFirstAndLastPositionOfElementInSortedArray().searchRange(nums, target);

        System.out.println(ans);
    }

}
