package com.lxr.leetcode;

import org.junit.Test;

public class ValidateBinarySearchTreeTest {

    @Test
    public void isValidBST() {
        ValidateBinarySearchTree.TreeNode root = new ValidateBinarySearchTree.TreeNode(Integer.MIN_VALUE);
        root.left = new ValidateBinarySearchTree.TreeNode(Integer.MIN_VALUE);
        root.right = new ValidateBinarySearchTree.TreeNode(Integer.MIN_VALUE);

        System.out.println(new ValidateBinarySearchTree().isValidBST(root));
    }

}
