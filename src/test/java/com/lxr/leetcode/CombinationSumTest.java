package com.lxr.leetcode;

import org.junit.Test;

import java.util.List;

/**
 * Created by lanxingren on 2019-11-29.
 */
public class CombinationSumTest {

    @Test
    public void combinationSum() {
        int[] candidates = new int[]{2, 3, 5};
        int target = 8;

        List<List<Integer>> ans = new CombinationSum().combinationSum(candidates, target);

        for (List<Integer> temp : ans) {
            for (Integer i : temp) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
