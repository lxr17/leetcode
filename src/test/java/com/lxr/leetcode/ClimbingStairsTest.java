package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2020/6/8.
 */
public class ClimbingStairsTest {

    @Test
    public void climbStairs() {
        int n = 45;

        int ans = new ClimbingStairs().climbStairs(n);

        System.out.println(ans);
    }

}
