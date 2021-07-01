package com.lxr.leetcode;

/**
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 * <p>
 * eg1.
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * <p>
 * eg2.
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 * <p>
 * Constraints:
 * The number of nodes in the list is n.
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * <p>
 * Follow up: Could you do it in one pass?
 */
public class ReverseLinkedListII {

    /**
     * 0ms     100.00% Run time
     * 36.6MB  65.91% Memory
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        int curIndex = 0;// 当前节点索引
        ListNode curNode = head; // 当前节点
        ListNode preNode = null; // 反转的前一个节点
        ListNode ans = head;

        // 1 2 3 4 5
        // 1 3 2 4 5
        // 1 4 3 2 5
        while (curNode.next != null) {
            if (curIndex < left - 1) { // 找到反转节点的前一个节点
                if (curIndex + 1 == left - 1) {
                    preNode = curNode;
                }

                curNode = curNode.next;
                curIndex++;
            } else if (curIndex >= left - 1 && curIndex < right - 1) {
                // 反转
                ListNode next = curNode.next;
                curNode.next = next.next;

                if (preNode == null) {
                    next.next = ans;
                    ans = next;
                } else {
                    next.next = preNode.next;
                    preNode.next = next;
                }

                curIndex++;
            } else {
                break;
            }
        }

        return ans;
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
