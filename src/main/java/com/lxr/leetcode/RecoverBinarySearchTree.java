package com.lxr.leetcode;

import java.util.Stack;

/**
 * You are given the root of a binary search tree (BST), where exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
 * <p>
 * Follow up: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 * <p>
 * eg1.
 * Input: root = [1,3,null,null,2]
 * Output: [3,1,null,null,2]
 * Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
 * <p>
 * eg2.
 * Input: root = [3,1,4,null,null,2]
 * Output: [2,1,4,null,null,3]
 * Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [2, 1000].
 * -2^31 <= Node.val <= 2^31 - 1
 */
public class RecoverBinarySearchTree {

    /**
     * 3ms     35.89% Run time
     * 39.3MB  71.04% Memory
     */
    public void recoverTree(TreeNode root) {
        // 思路：一个正常中序遍历的树是正序的：1 2 3 4 5 6 7 8
        // 而交换其中任意两个，会导致 1 2 6 4 5 3 7 8
        // 有两个节点的位置破坏了其正序
        // 如果交换相邻的两个，则 1 2 4 3 5 6 7 8
        // 只有一个节点的位置破坏了其正序
        // 因此重点在于找到破坏其顺序的节点
        TreeNode first = null;
        TreeNode second = null;

        // 遍历过程中的前一个节点
        TreeNode pre = null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        // 左树不断入栈
        while (stack.peek().left != null) {
            stack.push(stack.peek().left);
        }

        while (true) {
            if (stack.empty()) {
                break;
            }

            TreeNode cur = stack.peek();

            // 找到了
            if (pre != null && cur.val <= pre.val) {
                if (first == null) {
                    first = pre;
                    second = cur;
                } else {
                    second = cur;
                    break;
                }
            }

            // 继续遍历
            pre = cur;
            stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);

                // 左树不断入栈
                while (stack.peek().left != null) {
                    stack.push(stack.peek().left);
                }
            }
        }

        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
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
