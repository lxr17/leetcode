package com.lxr.leetcode;

/**
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 * <p>
 * eg.
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {

    /**
     * 185ms     12.39% Run time
     * 56.7 MB   5.47% Memory
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // 记录中途改变的值
        ListNode changedNode = new ListNode(-1);

        // 记录首位指针
        ListNode ans = changedNode;

        while (changedNode != null) {
            changedNode.next = findTheSmallestNode(lists);
            changedNode = changedNode.next;
        }

        return ans.next;
    }

    /**
     * 找到lists中最小的一个ListNode
     *
     * @param lists
     * @return
     */
    private ListNode findTheSmallestNode(ListNode[] lists) {
        ListNode smallest = null;
        int target = -1;

        for (int i = 0; i < lists.length; i++) {
            ListNode temp = lists[i];

            // 获取最小值
            if (temp != null && (smallest == null || temp.val <= smallest.val)) {
                smallest = temp;
                target = i;
            }
        }

        // 将最小值往后移动一个节点
        if (target != -1) {
            lists[target] = lists[target].next;
        }

        return smallest;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
