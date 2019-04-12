package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by he_jhua on 2019/4/8.
 */
public class MedianOfTwoSortedArraysTest {

    @Test
    public void findMedianSortedArrays() {
        int[] a = new int[]{1, 3, 5};
        int[] b = new int[]{2, 4, 6, 7};

        new MedianOfTwoSortedArrays().findMedianSortedArrays(a, b);

    }

}
