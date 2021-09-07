package com.lxr.leetcode;

import org.junit.Test;

public class ConvertSortedListToBinarySearchTreeTest {

    @Test
    public void sortedListToBST() {
        new ConvertSortedListToBinarySearchTree().sortedListToBST(null);
    }

    @Test
    public void sortedListToBST2() {
        //int[] arr = new int[]{-10, -3, 0, 5, 9};
        //int[] arr = new int[]{1, 3};
        //int[] arr = new int[]{1};
        int[] arr = new int[]{};
        ConvertSortedListToBinarySearchTree.ListNode head = createList(arr);

        ConvertSortedListToBinarySearchTree.TreeNode treeNode = new ConvertSortedListToBinarySearchTree().sortedListToBST2(head);

        System.out.println(treeNode);
    }

    @Test
    public void sortedListToBST3() {
        int[] arr = new int[]{-10, -3, 0, 5, 9};
        //int[] arr = new int[]{1, 3};
        //int[] arr = new int[]{1};
        //int[] arr = new int[]{};
        ConvertSortedListToBinarySearchTree.ListNode head = createList(arr);

        ConvertSortedListToBinarySearchTree.TreeNode treeNode = new ConvertSortedListToBinarySearchTree().sortedListToBST3(head);

        System.out.println(treeNode);
    }

    private ConvertSortedListToBinarySearchTree.ListNode createList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }

        ConvertSortedListToBinarySearchTree.ListNode head = new ConvertSortedListToBinarySearchTree.ListNode(arr[0]);
        ConvertSortedListToBinarySearchTree.ListNode cur = head;

        for (int i = 1, length = arr.length; i < length; i++) {
            cur.next = new ConvertSortedListToBinarySearchTree.ListNode(arr[i]);
            cur = cur.next;
        }

        return head;
    }
}
