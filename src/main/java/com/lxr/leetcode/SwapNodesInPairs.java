package com.lxr.leetcode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * eg.
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapNodesInPairs {

    /**
     * 0ms     100.00% Run time
     * 34.2MB 100.00% Memory
     */
    public ListNode swapPairs(ListNode head) {
        ListNode changedNode = new ListNode(-1);
        changedNode.next = head;

        ListNode initNode = changedNode;

        while (changedNode.next != null) {
            ListNode next = changedNode.next;
            ListNode nnext = next.next;

            // 交换相邻两节点
            if (nnext != null) {
                changedNode.next = nnext;

                ListNode temp = nnext.next;
                nnext.next = next;
                next.next = temp;
            }

            changedNode = next;
        }

        return initNode.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
