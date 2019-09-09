package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2019-09-09.
 */
public class ReverseNodesInKGroupTest {

    @Test
    public void reverseKGroup() {
        int[] aaa = new int[]{1, 2, 3, 4, 5};

        ReverseNodesInKGroup.ListNode node = createListNode(aaa);

        new ReverseNodesInKGroup().reverseKGroup(node, 5);

    }

    private ReverseNodesInKGroup.ListNode createListNode(int[] list) {
        ReverseNodesInKGroup.ListNode listNode = null;

        for (int i = list.length - 1; i >= 0; i--) {
            ReverseNodesInKGroup.ListNode lll = new ReverseNodesInKGroup.ListNode(list[i]);
            lll.next = listNode;
            listNode = lll;
        }

        return listNode;
    }
}
