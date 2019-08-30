package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * eg.
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * <p>
 * Note:
 * Given n will always be valid.
 * <p>
 * Follow up:
 * Could you do this in one pass?
 */
public class RemoveNthNodeFromEndOfList {

    /**
     * 1ms     10.52% Run time
     * 35.9 MB 100.00% Memory
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> listNodes = new ArrayList<>();

        // 将ListNode转为List集合
        listNodes.add(head);
        while (listNodes.get(listNodes.size() - 1).next != null) {
            listNodes.add(listNodes.get(listNodes.size() - 1).next);
        }

        if (listNodes.size() - n - 1 >= 0) {
            ListNode previousNode = listNodes.get(listNodes.size() - n - 1);
            previousNode.next = previousNode.next.next;
        } else {
            head = head.next;
        }

        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
