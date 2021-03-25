package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2021-03-25.
 */
public class MergeSortedArrayTest {

    @Test
    public void merge() {
        int[] nums1 = new int[]{2, 0};
        int[] nums2 = new int[]{1};

        new MergeSortedArray().merge(nums1, 1, nums2, 1);

        for (int i : nums1) {
            System.out.print(i + ", ");
        }
    }

}
