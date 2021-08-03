package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 * <p>
 * eg1.
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
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
public class BinaryTreeLevelOrderTraversal {

    /**
     * 0ms      100.00% Run time
     * 39.1MB   67.17% Memory
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        // 思路：其实就是一道广度遍历题
        // 注意：注意分层，ans 的每一个 item 都是一层里的所有数
        Queue<TreeNode> trees = new LinkedList<>();
        trees.add(root);

        int curCount = 1;
        int nextCount;

        while (!trees.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            nextCount = 0;

            // 遍历当前层
            while (curCount > 0) {
                TreeNode curTree = trees.poll();

                if (curTree.left != null) {
                    trees.add(curTree.left);
                    nextCount++;
                }

                if (curTree.right != null) {
                    trees.add(curTree.right);
                    nextCount++;
                }

                curLevel.add(curTree.val);

                curCount--;
            }

            ans.add(curLevel);
            curCount = nextCount;
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
