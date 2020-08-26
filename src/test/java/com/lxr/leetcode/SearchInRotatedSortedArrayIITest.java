package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2020-08-26.
 */
public class SearchInRotatedSortedArrayIITest {

    @Test
    public void search() {
        int[] nums = new int[]{1, 3, 1, 1, 1};

        int target = 3;

        boolean ans = new SearchInRotatedSortedArrayII().search(nums, target);

        System.out.println(ans);
    }

}
