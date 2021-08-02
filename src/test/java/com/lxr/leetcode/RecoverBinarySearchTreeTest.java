package com.lxr.leetcode;

import org.junit.Test;

public class RecoverBinarySearchTreeTest {

    @Test
    public void recoverTree() {
        RecoverBinarySearchTree.TreeNode root = new RecoverBinarySearchTree.TreeNode(2);
        root.left = new RecoverBinarySearchTree.TreeNode(1);
        root.right = new RecoverBinarySearchTree.TreeNode(3);

        int temp = root.left.val;
        root.left.val = root.right.val;
        root.right.val = temp;

        new RecoverBinarySearchTree().recoverTree(root);
    }

}
