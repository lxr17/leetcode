package com.lxr.leetcode;

import org.junit.Test;

import java.util.List;

public class UniqueBinarySearchTreesIITest {

    @Test
    public void generateTrees() {
        int length = 3;

        List<UniqueBinarySearchTreesII.TreeNode> ans = new UniqueBinarySearchTreesII().generateTrees(length);

        System.out.println(ans);
    }

}
