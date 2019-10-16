package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2019-10-16.
 */
public class SearchInRotatedSortedArrayTest {

    @Test
    public void search() {
        int[] nums = new int[]{4,5,6,7,8,9,0,1,2,3};

        int target = 0;

        int ans = new SearchInRotatedSortedArray().search(nums, target);

        System.out.println(ans);
    }

}
