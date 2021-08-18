package com.lxr.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
 * <p>
 * eg1.
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 * <p>
 * eg2.
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 * <p>
 * Constraints:
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder and postorder consist of unique values.
 * Each value of postorder also appears in inorder.
 * inorder is guaranteed to be the inorder traversal of the tree.
 * postorder is guaranteed to be the postorder traversal of the tree.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    /**
     * 15ms    5.08% Run time
     * 39.8MB  17.60% Memory
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 思路：迭代
        // 1. 找到根节点（根节点为 postorder 的最后一个节点）
        // 2. 拆分 inorder 与 postorder，分别得到左右子树的 inorder 与 postorder
        // 3. 分别找到左右子树的根节点
        // 4. 重复步骤 2. 和 3.

        // 步骤1.
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);

        TreeHelper helper = new TreeHelper();
        helper.treeNode = root;
        helper.inorder = inorder;
        helper.postorder = postorder;

        Queue<TreeHelper> queue = new LinkedList<>();
        queue.add(helper);

        // 步骤2,3,4
        while (true) {
            if (queue.isEmpty()) {
                break;
            }

            TreeHelper tempHelper = queue.poll();
            int splitIndex = -1;

            // 找出分割点
            for (int i = 0; i < tempHelper.inorder.length; i++) {
                if (tempHelper.inorder[i] == tempHelper.treeNode.val) {
                    splitIndex = i;
                    break;
                }
            }

            // 拆分
            int leftSize = splitIndex;
            int rightSize = tempHelper.inorder.length - splitIndex - 1;
            int[] leftInorder = new int[leftSize];
            int[] rightInorder = new int[rightSize];
            int[] leftPostorder = new int[leftSize];
            int[] rightPostorder = new int[rightSize];
            for (int i = 0; i < tempHelper.inorder.length; i++) {
                if (i < splitIndex) {
                    leftInorder[i] = tempHelper.inorder[i];
                } else if (i > splitIndex) {
                    rightInorder[i - splitIndex - 1] = tempHelper.inorder[i];
                }

                if (i < splitIndex) {
                    leftPostorder[i] = tempHelper.postorder[i];
                } else if (i < tempHelper.postorder.length - 1) {
                    rightPostorder[i - splitIndex] = tempHelper.postorder[i];
                }
            }
            if (leftSize > 0) {
                TreeNode leftTree = new TreeNode(leftPostorder[leftSize - 1]);
                tempHelper.treeNode.left = leftTree;

                if (leftSize > 1) {
                    TreeHelper leftHelper = new TreeHelper();
                    leftHelper.treeNode = leftTree;
                    leftHelper.inorder = leftInorder;
                    leftHelper.postorder = leftPostorder;

                    queue.add(leftHelper);
                }
            }
            if (rightSize > 0) {
                TreeNode rightTree = new TreeNode(rightPostorder[rightSize - 1]);
                tempHelper.treeNode.right = rightTree;

                if (rightSize > 1) {
                    TreeHelper rightHelper = new TreeHelper();
                    rightHelper.treeNode = rightTree;
                    rightHelper.inorder = rightInorder;
                    rightHelper.postorder = rightPostorder;

                    queue.add(rightHelper);
                }
            }
        }

        return root;
    }

    public static class TreeHelper {
        /**
         * 当前树
         */
        private TreeNode treeNode;

        /**
         * 当前树的中序遍历
         */
        private int[] inorder;

        /**
         * 当前树的后序遍历
         */
        private int[] postorder;
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
