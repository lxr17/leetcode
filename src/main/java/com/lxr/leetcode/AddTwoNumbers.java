package com.lxr.leetcode;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * eg.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // first position
        int first = l1.val + l2.val;
        // ten position
        int carry = first / 10;

        // every changed node
        ListNode node = new ListNode(first % 10);
        // root node
        ListNode root = node;
        while (l1.next != null || l2.next != null || carry != 0) {

            if (l1.next == null) {
                l1 = new ListNode(0);
            } else {
                l1 = l1.next;
            }

            if (l2.next == null) {
                l2 = new ListNode(0);
            } else {
                l2 = l2.next;
            }

            int temp = l1.val + l2.val + carry;
            carry = temp / 10;

            ListNode child = new ListNode(temp % 10);
            node.next = child;
            node = child;
        }

        return root;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
