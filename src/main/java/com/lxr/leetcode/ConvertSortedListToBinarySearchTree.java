package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * eg1.
 * Input: head = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
 * <p>
 * eg2.
 * Input: head = []
 * Output: []
 * <p>
 * eg3.
 * Input: head = [0]
 * Output: [0]
 * <p>
 * eg4.
 * Input: head = [1,3]
 * Output: [3,1]
 * <p>
 * Constraints:
 * The number of nodes in head is in the range [0, 2 * 10^4].
 * -10^5 <= Node.val <= 10^5
 */
public class ConvertSortedListToBinarySearchTree {

    /**
     * 2ms      10.50% Run time
     * 44.6MB   6.39% Memory
     */
    public TreeNode sortedListToBST(ListNode head) {
        // 思路：先转成有序集合，再进行转换
        List<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

        if (values.size() == 0) {
            return null;
        } else {
            return sortedArrayToBST(values);
        }
    }

    private TreeNode sortedArrayToBST(List<Integer> nums) {
        // 思路：递归
        return sortedArrayToBST(nums, 0, nums.size() - 1);
    }

    /**
     * 生成[startIndex, endIndex]的子树
     *
     * @param nums
     * @param startIndex
     * @param endIndex
     * @return
     */
    private TreeNode sortedArrayToBST(List<Integer> nums, int startIndex, int endIndex) {
        int middleIndex = (startIndex + endIndex) / 2;

        TreeNode curTree = new TreeNode(nums.get(middleIndex));

        if (startIndex < middleIndex) {
            curTree.left = sortedArrayToBST(nums, startIndex, middleIndex - 1);
        }

        if (endIndex > middleIndex) {
            curTree.right = sortedArrayToBST(nums, middleIndex + 1, endIndex);
        }

        return curTree;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public class TreeNode {
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
