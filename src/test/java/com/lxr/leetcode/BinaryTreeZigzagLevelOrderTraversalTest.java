package com.lxr.leetcode;

import org.junit.Test;

public class BinaryTreeZigzagLevelOrderTraversalTest {

    @Test
    public void zigzagLevelOrder() {
        BinaryTreeZigzagLevelOrderTraversal.TreeNode root = new BinaryTreeZigzagLevelOrderTraversal.TreeNode(3);
        root.left = new BinaryTreeZigzagLevelOrderTraversal.TreeNode(9);
        root.right = new BinaryTreeZigzagLevelOrderTraversal.TreeNode(20);
        root.right.left = new BinaryTreeZigzagLevelOrderTraversal.TreeNode(15);
        root.right.right = new BinaryTreeZigzagLevelOrderTraversal.TreeNode(7);

        new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root);
    }

}
