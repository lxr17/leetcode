package com.lxr.leetcode;

import org.junit.Test;

public class SameTreeTest {

    @Test
    public void isSameTree() {
        SameTree.TreeNode p = new SameTree.TreeNode(1);
        p.left = new SameTree.TreeNode(2);
        p.right = new SameTree.TreeNode(1);

        SameTree.TreeNode q = new SameTree.TreeNode(1);
        q.left = new SameTree.TreeNode(1);
        q.right = new SameTree.TreeNode(2);

        System.out.println(new SameTree().isSameTree(p, q));
    }

}
