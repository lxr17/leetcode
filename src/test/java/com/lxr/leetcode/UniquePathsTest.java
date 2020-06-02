package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2020/6/2.
 */
public class UniquePathsTest {

    @Test
    public void uniquePaths() {
        int m = 2311;
        int n = 1211;

        int ans = new UniquePaths().uniquePaths(m, n);

        System.out.println(ans);
    }

}
