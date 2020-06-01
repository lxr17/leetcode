package com.lxr.leetcode;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * eg1.
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * <p>
 * eg2.
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */
public class RotateList {

    /**
     * 0ms     100.00% Run time
     * 39.2MB  41.38% Memory
     */
    public ListNode rotateRight(ListNode head, int k) {
        // 当前节点
        ListNode current = head;
        // ListNode长度
        int length = 0;

        // 非空判断
        if (current != null) {
            length++;
        } else {
            return null;
        }

        // 将链表变成一个圈
        while (current.next != null) {
            current = current.next;
            length++;
        }
        current.next = head;
        current = head;

        // 优化k
        k = k % length;

        // 开始转圈（顺时针转k == 逆时针转length-k），找到关键节点的前一个
        for (int i = 0; i < length - k - 1; i++) {
            current = current.next;
        }

        ListNode ans = current.next;
        current.next = null;

        return ans;
    }

    static class ListNode {
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

}
