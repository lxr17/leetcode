package com.lxr.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
 * <p>
 * eg1.
 * Input: n = 3
 * Output: 5
 * <p>
 * eg2.
 * Input: n = 1
 * Output: 1
 * <p>
 * Constraints:
 * 1 <= n <= 19
 */
public class UniqueBinarySearchTrees {

    /**
     * 0ms      100.00% Run time
     * 35.7MB   66.59% Memory
     */
    public int numTrees(int n) {
        // key为树的长度，value为一共有多少种结构
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        map.put(1, 1);
        map.put(2, 2);

        for (int i = 3; i <= n; i++) {
            int sum = 0;

            // 计算根节点是1,2,3...i的时候，一共有多少种方式
            for (int j = 1; j <= i; j++) {
                sum = sum + map.get(j - 1) * map.get(i - j);
            }

            map.put(i, sum);
        }

        return map.get(n);
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
