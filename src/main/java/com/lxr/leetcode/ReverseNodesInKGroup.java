package com.lxr.leetcode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time
 * and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * eg.
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * <p>
 * Note:
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class ReverseNodesInKGroup {

    /**
     * 0ms      100.00% Run time
     * 39MB    22.42% Memory
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode[] ans = null;
        ListNode result = null;
        ListNode last = null;

        // 单独处理k等于1的情况
        if (k == 1) {
            return head;
        }

        int size = size(head);

        while (head != null && size >= k) {
            // 反转前k个
            ans = reverseK(head, k);

            if (result == null) {
                result = ans[0];
            } else {
                last.next = ans[0];
            }

            last = ans[2];
            head = ans[1];
            size = size - k;
        }

        if (k > 0 && last != null) {
            last.next = head;
        }

        // 解决head长度小于k的情况
        if (result == null) {
            result = head;
        }

        return result;
    }

    /**
     * 只反转最开始的k个节点
     * <p>
     * 返回的数组中第一个为反转之后的ListNode;
     * 第二个为下一个节点的ListNode;
     * 第三个为最后一个节点的ListNode;
     *
     * @param head
     * @param k
     * @return
     */
    private ListNode[] reverseK(ListNode head, int k) {
        ListNode[] ans = new ListNode[3];

        // 遍历中途一直指向当前节点
        ListNode changedNode = head.next;

        // 反转之后的ListNode
        ans[0] = head;
        ans[0].next = null;

        // 最后一个节点的ListNode
        ans[2] = head;

        // 暂存next节点
        ListNode temp;

        // 逐步增加rest的长度
        while (changedNode != null && k > 1) {
            // 暂存下一节点
            temp = changedNode.next;

            // 增长rest节点
            changedNode.next = ans[0];
            ans[0] = changedNode;

            // 指向下一节点
            changedNode = temp;

            k--;

            // 下一节点的ListNode
            if (k == 1) {
                ans[1] = changedNode;
            }
        }

        return ans;
    }

    /**
     * 计算ListNode的长度
     *
     * @param listNode
     * @return
     */
    private int size(ListNode listNode) {
        int size = 0;

        while (listNode != null) {
            size++;
            listNode = listNode.next;
        }

        return size;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
