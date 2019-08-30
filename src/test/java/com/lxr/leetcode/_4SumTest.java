package com.lxr.leetcode;

import org.junit.Test;

import java.util.List;

/**
 * Created by lanxingren on 2019-08-30.
 */
public class _4SumTest {

    @Test
    public void fourSum() {
        int[] sums = new int[]{-3, -2, -1, 0, 0, 1, 2, 3};

        List<List<Integer>> list = new _4Sum().fourSum(sums, 0);

        for (List<Integer> temp : list) {
            for (Integer i : temp) {
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }

}
