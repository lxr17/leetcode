package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2019-08-30.
 */
public class RemoveNthNodeFromEndOfListTest {

    @Test
    public void removeNthFromEnd() {
        RemoveNthNodeFromEndOfList.ListNode listNode5 = new RemoveNthNodeFromEndOfList.ListNode(5);
        RemoveNthNodeFromEndOfList.ListNode listNode4 = new RemoveNthNodeFromEndOfList.ListNode(4);
        RemoveNthNodeFromEndOfList.ListNode listNode3 = new RemoveNthNodeFromEndOfList.ListNode(3);
        RemoveNthNodeFromEndOfList.ListNode listNode2 = new RemoveNthNodeFromEndOfList.ListNode(2);
        RemoveNthNodeFromEndOfList.ListNode listNode1 = new RemoveNthNodeFromEndOfList.ListNode(1);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        RemoveNthNodeFromEndOfList.ListNode lll = new RemoveNthNodeFromEndOfList().removeNthFromEnd(listNode5, 1);
    }

}
