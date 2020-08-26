package com.lxr.leetcode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * Return the linked list sorted as well.
 * <p>
 * eg1.
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * <p>
 * eg2.
 * Input: 1->1->1->2->3
 * Output: 2->3
 */
public class RemoveDuplicatesFromSortedListII {

    /**
     * 0ms     100.00% Run time
     * 39.4MB  43.64% Memory
     */
    public ListNode deleteDuplicates(ListNode head) {
        // 作一个非空判断
        if (head == null) {
            return null;
        }

        // 新链表的头的前一个节点
        ListNode newHead = new ListNode();

        // 新链表的当前节点
        ListNode currNew = newHead;

        // 旧链表的当前节点
        ListNode curr = head;

        // 上一个节点的值
        int lastVal = curr.val;

        while (curr.next != null) {
            // 如果当前节点的值和下一个节点的值不相同，并且和上一个节点的值也不相同（第一个节点除外），则加入新链表
            if (curr.val != curr.next.val && (curr == head || curr.val != lastVal)) {
                currNew.next = curr;
                currNew = currNew.next;
            }

            lastVal = curr.val;
            curr = curr.next;
        }

        // 判断最后一个节点的情况
        if (curr == head || curr.val != lastVal) {
            currNew.next = curr;
            currNew = currNew.next;
        }

        // 去掉多余的节点（很重要）
        currNew.next = null;

        return newHead.next;
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
