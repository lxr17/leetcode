package com.lxr.leetcode;

import org.junit.Test;

import java.util.List;

public class SubsetsIITest {

    @Test
    public void subsetsWithDup() {
        int[] nums = new int[]{};

        List<List<Integer>> ans = new SubsetsII().subsetsWithDup(nums);

        System.out.println(ans);
    }

}
