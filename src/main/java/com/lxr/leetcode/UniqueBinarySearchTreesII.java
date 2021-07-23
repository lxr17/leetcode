package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
 * <p>
 * eg1.
 * Input: n = 3
 * Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * <p>
 * eg2.
 * Input: n = 1
 * Output: [[1]]
 * <p>
 * Constraints:
 * 1 <= n <= 8
 */
public class UniqueBinarySearchTreesII {

    /**
     * 0ms    100.00% Run time
     * 39MB   95.06% Memory
     */
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> pre = new ArrayList<>();
        List<TreeNode> cur = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            cur.clear();

            if (i == 0) {
                // 找到长度为1的所有树
                TreeNode treeNode = new TreeNode(i + 1);
                cur.add(treeNode);
            } else {
                // 找到长度大于1的所有树
                // 1. 新增的节点是根节点
                // 2. 新增的节点插入到 根节点 和 右树 之间，原右树为新增加点的左树
                // 3. 新增的节点插入到 右树 和 右树的右树 之间
                // 4. ...
                for (int j = 0; j < pre.size(); j++) {
                    // 需要往preItem中插入新的节点
                    TreeNode preItem = pre.get(j);

                    // 新增的节点为根节点
                    TreeNode root = new TreeNode(i + 1);
                    root.left = preItem;
                    cur.add(root);

                    // 新增的节点在右边(k代表第k个right)
                    int k = 0;
                    loop:
                    while (true) {
                        TreeNode rootCopy = cloneTree(preItem);
                        TreeNode right = rootCopy;

                        // 找到第k个right，找不到的话就结束遍历
                        for (int m = 0; m < k; m++) {
                            if (right.right != null) {
                                right = right.right;
                            } else {
                                // 找不到第k个right，结束while循环
                                break loop;
                            }
                        }

                        TreeNode insertNode = new TreeNode(i + 1);
                        insertNode.left = right.right;
                        right.right = insertNode;
                        cur.add(rootCopy);

                        k++;
                    }
                }

            }

            pre.clear();
            pre.addAll(cur);
        }

        return cur;
    }

    /**
     * 因为左树不涉及到改变，所以只需要完全复制右树
     *
     * @param treeNode
     * @return
     */
    private TreeNode cloneTree(TreeNode treeNode) {
        TreeNode clonedTree = new TreeNode(treeNode.val);
        clonedTree.left = treeNode.left;

        if (treeNode.right != null) {
            clonedTree.right = cloneTree(treeNode.right);
        }

        return clonedTree;
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