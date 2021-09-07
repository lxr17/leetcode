package com.lxr.leetcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class BalancedBinaryTreeTest {

    @Test
    public void isBalanced() {
        Integer[] arr = new Integer[]{3, 9, 20, null, null, 15, 7};
        BalancedBinaryTree.TreeNode treeNode = createTree(arr);

        boolean isBalanced = new BalancedBinaryTree().isBalanced(treeNode);

        System.out.println(isBalanced);
    }

    private BalancedBinaryTree.TreeNode createTree(Integer[] arr) {
        if (arr.length == 0) {
            return null;
        }

        Queue<BalancedBinaryTree.TreeNode> queue = new LinkedList<>();
        BalancedBinaryTree.TreeNode root = new BalancedBinaryTree.TreeNode(arr[0]);
        queue.add(root);

        int i = 1;
        while (i < arr.length) {
            BalancedBinaryTree.TreeNode cur = queue.poll();

            if (cur == null) {
                i += 2;
                continue;
            }

            if (arr[i] != null) {
                cur.left = new BalancedBinaryTree.TreeNode(arr[i]);
            }
            queue.add(cur.left);
            i += 1;

            if (i < arr.length) {
                if (arr[i] != null) {
                    cur.right = new BalancedBinaryTree.TreeNode(arr[i]);
                }
                queue.add(cur.right);
                i += 1;
            }
        }

        return root;
    }
}
