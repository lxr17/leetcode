package com.lxr.leetcode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as:
 * <p>
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 * <p>
 * eg1.
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 * <p>
 * eg2.
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 * <p>
 * eg3.
 * Input: root = []
 * Output: true
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [0, 5000].
 * -10^4 <= Node.val <= 10^4
 */
public class BalancedBinaryTree {

    /**
     * 1ms     53.98% Run time
     * 38.6MB  97.47% Memory
     */
    public boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root)[0] == 1;
    }

    /**
     * 判断树是否为平衡树，并找出树的最大深度
     *
     * @param root
     * @return int[0]表示该树是否为平衡树，int[1]表示该树的最大深度
     */
    private int[] isBalancedHelper(TreeNode root) {
        if (root == null) {
            return new int[]{1, 0};
        }

        int isBalanced;
        int depth = 1;

        int[] left = isBalancedHelper(root.left);
        int[] right = isBalancedHelper(root.right);

        if (left[0] == 1 && right[0] == 1 && Math.abs(left[1] - right[1]) <= 1) {
            isBalanced = 1;
        } else {
            isBalanced = 0;
        }

        depth += Math.max(left[1], right[1]);

        return new int[]{isBalanced, depth};
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
