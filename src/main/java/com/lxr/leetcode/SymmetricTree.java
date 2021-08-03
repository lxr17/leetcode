package com.lxr.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * <p>
 * eg1.
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * <p>
 * eg2.
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 */
public class SymmetricTree {

    /**
     * 0ms      100.00% Run time
     * 38.2MB   29.97% Memory
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        // 其中一支树为空
        if (root.left == null || root.right == null) {
            return false;
        }

        // 思路：对左右树分别进行广度遍历
        Queue<TreeNode> leftTrees = new LinkedList<>();
        Queue<TreeNode> rightTrees = new LinkedList<>();

        leftTrees.add(root.left);
        rightTrees.add(root.right);

        while (true) {
            TreeNode left = leftTrees.poll();
            TreeNode right = rightTrees.poll();

            if (left == null && right == null) {
                return true;
            }

            // 由于 leftTrees 和 rightTrees 的 size 一致，故此时 left 和 right 均非空
            if (left.val != right.val) {
                return false;
            }

            // 左树的左子树入队，右树的右子树入队
            if (left.left != null || right.right != null) {
                if (left.left == null || right.right == null) {
                    return false;
                }

                // 此时 left.left 和 right.right 均非空
                leftTrees.add(left.left);
                rightTrees.add(right.right);
            }

            // 左树的右子树入队，右树的左子树入队
            if (left.right != null || right.left != null) {
                if (left.right == null || right.left == null) {
                    return false;
                }

                // 此时 left.right 和 right.left 均非空
                leftTrees.add(left.right);
                rightTrees.add(right.left);
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
