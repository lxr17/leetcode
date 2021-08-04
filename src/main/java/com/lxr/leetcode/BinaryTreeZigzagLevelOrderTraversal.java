package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 * <p>
 * eg1.
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
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
 * <p>
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    /**
     * 0ms     100.00% Run time
     * 39.2MB  34.28% Memory
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        // 当前层
        List<TreeNode> curLevel = new ArrayList<>();

        // 下一层
        List<TreeNode> nextLevel = new ArrayList<>();

        // 是否从左往右
        boolean leftToRight = true;

        curLevel.add(root);

        while (true) {
            if (curLevel.size() == 0) {
                break;
            }

            List<Integer> level = new ArrayList<>();

            if (leftToRight) {
                for (int i = curLevel.size() - 1; i >= 0; i--) {
                    TreeNode cur = curLevel.get(i);
                    level.add(cur.val);

                    if (cur.left != null) {
                        nextLevel.add(cur.left);
                    }

                    if (cur.right != null) {
                        nextLevel.add(cur.right);
                    }
                }
            } else {
                for (int i = curLevel.size() - 1; i >= 0; i--) {
                    TreeNode cur = curLevel.get(i);
                    level.add(cur.val);

                    if (cur.right != null) {
                        nextLevel.add(cur.right);
                    }

                    if (cur.left != null) {
                        nextLevel.add(cur.left);
                    }
                }
            }

            ans.add(level);

            leftToRight = !leftToRight;
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
