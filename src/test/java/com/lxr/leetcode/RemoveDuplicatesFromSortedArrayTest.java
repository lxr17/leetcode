package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2019-09-09.
 */
public class RemoveDuplicatesFromSortedArrayTest {

    @Test
    public void removeDuplicates() {
        int[] aaa = new int[]{1, 1, 1, 2, 3, 3, 3, 3, 3, 4, 5, 5, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7};

        int b = new RemoveDuplicatesFromSortedArray().removeDuplicates(aaa);

        System.out.println(b);
    }

}
