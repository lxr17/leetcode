package com.lxr.leetcode;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * eg.
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {

    /**
     * 0ms     100.00% Run time
     * 39.9 MB 15.83% Memory
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 记录中途改变的值
        ListNode changedNode = new ListNode(-1);

        // 记录首位指针
        ListNode ans = changedNode;

        while (l1 != null || l2 != null) {
            // l1==null时下一个值应为l2
            if (l1 == null) {
                changedNode.next = l2;
                l2 = l2.next;
                changedNode = changedNode.next;
                continue;
            }

            // l2==null时下一个值应为l1
            if (l2 == null) {
                changedNode.next = l1;
                l1 = l1.next;
                changedNode = changedNode.next;
                continue;
            }

            // l1 <= l2时下一个值应为l1
            if (l1.val <= l2.val) {
                changedNode.next = l1;
                l1 = l1.next;
                changedNode = changedNode.next;
            } else {
                // l1 > l2时下一个值应为l1
                changedNode.next = l2;
                l2 = l2.next;
                changedNode = changedNode.next;
            }
        }

        return ans.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
