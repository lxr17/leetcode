package com.lxr.leetcode;

import org.junit.Test;

import java.util.List;

/**
 * Created by lanxingren on 2020/7/1.
 */
public class SubsetsTest {

    @Test
    public void subsets() {
        int[] nums = new int[]{1};

        List<List<Integer>> ans = new Subsets().subsets(nums);

        System.out.println(ans);
    }

}
