package com.lxr.leetcode;

import org.junit.Test;

public class UniqueBinarySearchTreesTest {

    @Test
    public void numTrees() {
        int n = 19;

        int ans = new UniqueBinarySearchTrees().numTrees(n);

        System.out.println(ans);
    }

}
