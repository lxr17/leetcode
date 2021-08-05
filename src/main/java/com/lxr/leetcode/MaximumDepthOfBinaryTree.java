package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return its maximum depth.
 * <p>
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * eg1.
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * <p>
 * eg2.
 * Input: root = [1,null,2]
 * Output: 2
 * <p>
 * eg3.
 * Input: root = []
 * Output: 0
 * <p>
 * eg4.
 * Input: root = [0]
 * Output: 1
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 */
public class MaximumDepthOfBinaryTree {

    /**
     * 2ms     14.55% Run time
     * 38.8MB  78.78% Memory
     */
    public int maxDepth(TreeNode root) {
        int depth = 0;

        if (root == null) {
            return depth;
        }

        List<TreeNode> curLevel = new ArrayList<>();
        List<TreeNode> nextLevel = new ArrayList<>();

        curLevel.add(root);

        while (curLevel.size() != 0) {
            depth++;

            for (TreeNode treeNode : curLevel) {
                if (treeNode.left != null) {
                    nextLevel.add(treeNode.left);
                }

                if (treeNode.right != null) {
                    nextLevel.add(treeNode.right);
                }
            }

            curLevel.clear();
            curLevel.addAll(nextLevel);
            nextLevel.clear();
        }

        return depth;
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
