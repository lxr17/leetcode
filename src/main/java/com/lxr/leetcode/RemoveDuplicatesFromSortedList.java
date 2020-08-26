package com.lxr.leetcode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * eg1.
 * Input: 1->1->2
 * Output: 1->2
 * <p>
 * eg2.
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class RemoveDuplicatesFromSortedList {

    /**
     * 0ms     100.00% Run time
     * 39.3MB  50.77% Memory
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        // 新链表当前节点
        ListNode currNew = head;

        // 当前节点
        ListNode curr = head;

        while (curr.next != null) {
            if (curr.val != curr.next.val) {
                currNew.next = curr.next;
                currNew = currNew.next;
            }

            curr = curr.next;
        }

        // 清空多余节点
        currNew.next = null;

        return head;
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
