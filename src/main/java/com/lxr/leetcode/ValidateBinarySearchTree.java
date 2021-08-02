package com.lxr.leetcode;

import java.util.Stack;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * A valid BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * eg1.
 * Input: root = [2,1,3]
 * Output: true
 * <p>
 * eg2.
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [1, 104].
 * -2^31 <= Node.val <= 2^31 - 1
 */
public class ValidateBinarySearchTree {

    /**
     * 2ms      10.48% Run time
     * 38.5MB   79.66% Memory
     */
    public boolean isValidBST(TreeNode root) {
        // 思路：利用中序遍历来检查是否按照正确的顺序
        // stack 用来存储遍历过程中树的节点
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        // 注：这里不能用 int ，用 int 会导致 [Integer.MIN_VALUE] 通过不了
        Integer pre = null;

        while (true) {
            if (stack.empty()) {
                return true;
            }

            TreeNode cur = stack.peek();

            if (cur.left != null) {
                stack.push(cur.left);
                cur.left = null;
                continue;
            }

            // 比较当前节点
            if (pre != null && cur.val <= pre) {
                return false;
            } else {
                pre = cur.val;
            }

            stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
