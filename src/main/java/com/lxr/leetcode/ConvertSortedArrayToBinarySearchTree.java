package com.lxr.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 * <p>
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 * <p>
 * eg1.
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted.
 * <p>
 * eg2.
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,3] and [3,1] are both a height-balanced BSTs.
 * <p>
 * Constraints:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in a strictly increasing order.
 */
public class ConvertSortedArrayToBinarySearchTree {

    /**
     * 0ms      100.00% Run time
     * 38.5MB   90.74% Memory
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        // 思路：递归
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    /**
     * 生成[startIndex, endIndex]的子树
     *
     * @param nums
     * @param startIndex
     * @param endIndex
     * @return
     */
    private TreeNode sortedArrayToBST(int[] nums, int startIndex, int endIndex) {
        int middleIndex = (startIndex + endIndex) / 2;

        TreeNode curTree = new TreeNode(nums[middleIndex]);

        if (startIndex < middleIndex) {
            curTree.left = sortedArrayToBST(nums, startIndex, middleIndex - 1);
        }

        if (endIndex > middleIndex) {
            curTree.right = sortedArrayToBST(nums, middleIndex + 1, endIndex);
        }

        return curTree;
    }

    /**
     * 1ms    5.92% Run time
     * 39MB   27.20% Memory
     */
    public TreeNode sortedArrayToBST2(int[] nums) {
        // 思路：迭代
        Queue<TreeHelper> level = new LinkedList<>();

        int middleIndex = (nums.length - 1) / 2;
        TreeNode root = new TreeNode(nums[middleIndex]);

        TreeHelper rootHelper = new TreeHelper();
        rootHelper.curTree = root;
        rootHelper.startIndex = 0;
        rootHelper.endIndex = nums.length - 1;
        level.add(rootHelper);

        while (!level.isEmpty()) {
            TreeHelper helper = level.poll();

            if (helper.startIndex == helper.endIndex) {
                continue;
            }

            middleIndex = (helper.startIndex + helper.endIndex) / 2;

            if (helper.startIndex < middleIndex) {
                TreeHelper leftHelper = new TreeHelper();

                int leftMiddle = (helper.startIndex + middleIndex - 1) / 2;
                TreeNode leftTree = new TreeNode(nums[leftMiddle]);

                leftHelper.startIndex = helper.startIndex;
                leftHelper.endIndex = middleIndex - 1;
                leftHelper.curTree = leftTree;

                helper.curTree.left = leftTree;
                level.add(leftHelper);
            }

            if (helper.endIndex > middleIndex) {
                TreeHelper rightHelper = new TreeHelper();

                int rightMiddle = (helper.endIndex + middleIndex + 1) / 2;
                TreeNode rightTree = new TreeNode(nums[rightMiddle]);

                rightHelper.startIndex = middleIndex + 1;
                rightHelper.endIndex = helper.endIndex;
                rightHelper.curTree = rightTree;

                helper.curTree.right = rightTree;
                level.add(rightHelper);
            }
        }

        return rootHelper.curTree;
    }

    public static class TreeHelper {
        private TreeNode curTree;
        private int startIndex;
        private int endIndex;
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
