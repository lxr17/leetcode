package com.lxr.leetcode;

import org.junit.Test;

import java.util.List;

/**
 * Created by lanxingren on 2019-12-06.
 */
public class CombinationSumIITest {

    @Test
    public void combinationSum2() {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target = 8;

        List<List<Integer>> ans = new CombinationSumII().combinationSum2(candidates, target);

        for (List<Integer> temp : ans) {
            for (Integer i : temp) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
