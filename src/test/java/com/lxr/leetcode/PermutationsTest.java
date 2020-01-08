package com.lxr.leetcode;

import org.junit.Test;

import java.util.List;

/**
 * Created by lanxingren on 2020-01-08.
 */
public class PermutationsTest {

    @Test
    public void permute() {
        int[] nums = new int[]{};

        List<List<Integer>> ans = new Permutations().permute(nums);

        for (List<Integer> item : ans) {
            for (int i : item) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
