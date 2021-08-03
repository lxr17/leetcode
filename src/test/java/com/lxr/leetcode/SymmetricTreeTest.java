package com.lxr.leetcode;

import org.junit.Test;

public class SymmetricTreeTest {

    @Test
    public void isSymmetric() {
        SymmetricTree.TreeNode root = new SymmetricTree.TreeNode(2);
        root.left = new SymmetricTree.TreeNode(1);
        root.right = new SymmetricTree.TreeNode(1);

        root.left.left = new SymmetricTree.TreeNode(4);
        root.left.right = new SymmetricTree.TreeNode(3);
        root.right.right = new SymmetricTree.TreeNode(4);
        root.right.left = new SymmetricTree.TreeNode(3);

        System.out.println(new SymmetricTree().isSymmetric(root));
    }

}
