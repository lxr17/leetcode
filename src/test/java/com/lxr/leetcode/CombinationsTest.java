package com.lxr.leetcode;

import org.junit.Test;

import java.util.List;

/**
 * Created by lanxingren on 2020/6/20.
 */
public class CombinationsTest {

    @Test
    public void combine() {
        int n = 4;
        int k = 2;

        List<List<Integer>> ans = new Combinations().combine(n, k);

        System.out.println(ans.size());
    }

}
