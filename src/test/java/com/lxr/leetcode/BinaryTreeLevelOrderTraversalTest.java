package com.lxr.leetcode;

import org.junit.Test;

public class BinaryTreeLevelOrderTraversalTest {

    @Test
    public void levelOrder() {
        BinaryTreeLevelOrderTraversal.TreeNode root = new BinaryTreeLevelOrderTraversal.TreeNode(1);
        root.left = new BinaryTreeLevelOrderTraversal.TreeNode(2);
        root.right = new BinaryTreeLevelOrderTraversal.TreeNode(3);
        root.left.left = new BinaryTreeLevelOrderTraversal.TreeNode(4);
        root.right.right = new BinaryTreeLevelOrderTraversal.TreeNode(5);
        System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder(root));
    }

}
