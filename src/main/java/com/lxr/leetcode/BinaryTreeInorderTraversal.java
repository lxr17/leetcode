package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * eg1.
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 * <p>
 * eg2.
 * Input: root = []
 * Output: []
 * <p>
 * eg3.
 * Input: root = [1]
 * Output: [1]
 * <p>
 * eg4.
 * Input: root = [1,2]
 * Output: [2,1]
 * <p>
 * eg5.
 * Input: root = [1,null,2]
 * Output: [1,2]
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * <p>
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {

    /**
     * 0ms     100.00% Run time
     * 37.3MB  47.05% Memory
     * 递归方式
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        if (root.left != null) {
            inorderRecursive(root.left, ans);
        }

        ans.add(root.val);

        if (root.right != null) {
            inorderRecursive(root.right, ans);
        }

        return ans;
    }

    private void inorderRecursive(TreeNode treeNode, List<Integer> ans) {
        if (treeNode.left != null) {
            inorderRecursive(treeNode.left, ans);
        }

        ans.add(treeNode.val);

        if (treeNode.right != null) {
            inorderRecursive(treeNode.right, ans);
        }
    }

    /**
     * 0ms     100.00% Run time
     * 36.9MB  93.93% Memory
     * 迭代方式
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (stack.peek() != null) {
            TreeNode cur = stack.peek();

            // 左树入栈
            if (cur.left != null) {
                stack.push(cur.left);
                cur.left = null;
                continue;
            }

            ans.add(cur.val);
            stack.pop();

            // 右树入栈
            if (cur.right != null) {
                stack.push(cur.right);
            }
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
