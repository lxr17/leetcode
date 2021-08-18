package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).
 * <p>
 * eg1.
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[15,7],[9,20],[3]]
 * <p>
 * eg2.
 * Input: root = [1]
 * Output: [[1]]
 * <p>
 * eg3.
 * Input: root = []
 * Output: []
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 */
public class BinaryTreeLevelOrderTraversalII {

    /**
     * 1ms      84.79% Run time
     * 39.3MB   55.72% Memory
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        // 思路：广度遍历
        List<TreeNode> curLevel = new ArrayList<>();
        List<TreeNode> nextLevel = new ArrayList<>();

        curLevel.add(root);

        while (curLevel.size() > 0) {
            List<Integer> level = new ArrayList<>();

            for (TreeNode treeNode : curLevel) {
                level.add(treeNode.val);

                if (treeNode.left != null) {
                    nextLevel.add(treeNode.left);
                }

                if (treeNode.right != null) {
                    nextLevel.add(treeNode.right);
                }
            }

            ans.add(0, level);
            curLevel.clear();
            curLevel.addAll(nextLevel);
            nextLevel.clear();
        }

        return ans;
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
