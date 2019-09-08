package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2019-09-08.
 */
public class SwapNodesInPairsTest {

    @Test
    public void swapPairs() {
        int[] aaa = new int[]{1, 2, 3, 4, 5, 6, 7};
        SwapNodesInPairs.ListNode listNode = createListNode(aaa);

        new SwapNodesInPairs().swapPairs(listNode);
    }

    private SwapNodesInPairs.ListNode createListNode(int[] list) {
        SwapNodesInPairs.ListNode listNode = null;

        for (int i = list.length - 1; i >= 0; i--) {
            SwapNodesInPairs.ListNode lll = new SwapNodesInPairs.ListNode(list[i]);
            lll.next = listNode;
            listNode = lll;
        }

        return listNode;
    }

}
