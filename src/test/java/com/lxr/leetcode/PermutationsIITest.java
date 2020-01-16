package com.lxr.leetcode;

import org.junit.Test;

import java.util.List;

/**
 * Created by lanxingren on 2020-01-08.
 */
public class PermutationsIITest {

    @Test
    public void permuteUnique() {
        int[] nums = new int[] {3,3,1,1};

        List<List<Integer>> ans = new PermutationsII().permuteUnique(nums);

        for (List<Integer> item : ans) {
            for (int i : item) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
