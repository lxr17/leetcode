package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2020-08-11.
 */
public class RemoveDuplicatesFromSortedArrayIITest {

    @Test
    public void removeDuplicates() {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 8, 8, 9, 9, 9};

        System.out.println(new RemoveDuplicatesFromSortedArrayII().removeDuplicates(nums));

        System.out.println(nums);
    }

}
