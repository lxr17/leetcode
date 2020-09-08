package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2020/9/8.
 */
public class PartitionListTest {

    @Test
    public void partition() {
        int[] params = new int[]{1, 4, 3, 2, 5, 2};

        int x = 4;

        PartitionList.ListNode node = new PartitionList().partition(createListNode(params), x);

        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
    }

    private PartitionList.ListNode createListNode(int[] params) {
        PartitionList.ListNode ans = new PartitionList.ListNode();
        PartitionList.ListNode current = ans;

        current.val = params[0];

        for (int i = 1; i < params.length; i++) {
            PartitionList.ListNode listNode = new PartitionList.ListNode();
            listNode.val = params[i];

            current.next = listNode;
            current = listNode;
        }

        return ans;
    }

}
