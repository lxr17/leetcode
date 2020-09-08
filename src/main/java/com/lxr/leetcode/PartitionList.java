package com.lxr.leetcode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * eg.
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */
public class PartitionList {

    /**
     * 0ms     100.00% Run time
     * 39.2MB  53.73% Memory
     */
    public ListNode partition(ListNode head, int x) {
        // 小于x的节点头
        ListNode smallHead = new ListNode();

        // 小于x的节点尾
        ListNode curSmall = smallHead;

        // 大于等于x的节点头
        ListNode notSmallHead = new ListNode();

        // 大于等于x的节点尾
        ListNode curNotSmall = notSmallHead;

        while (head != null) {
            if (head.val < x) {
                curSmall.next = head;
                curSmall = curSmall.next;
            } else {
                curNotSmall.next = head;
                curNotSmall = curNotSmall.next;
            }

            head = head.next;
        }

        curSmall.next = notSmallHead.next;
        curNotSmall.next = null;

        return smallHead.next;
    }

    public static class ListNode {
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
