package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2019-11-01.
 */
public class SearchInsertPositionTest {

    @Test
    public void searchInsert() {
        int[] nums = new int[]{};

        int target = 4;

        int ans = new SearchInsertPosition().searchInsert(nums, target);

        System.out.println(ans);
    }

}
