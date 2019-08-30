package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2019-08-30.
 */
public class MergeTwoSortedListsTest {

    @Test
    public void mergeTwoLists() {
        MergeTwoSortedLists.ListNode listNode1 = new MergeTwoSortedLists.ListNode(-9);
        MergeTwoSortedLists.ListNode listNode2 = new MergeTwoSortedLists.ListNode(3);
        MergeTwoSortedLists.ListNode listNode3 = new MergeTwoSortedLists.ListNode(4);
        MergeTwoSortedLists.ListNode listNode4 = new MergeTwoSortedLists.ListNode(5);
        MergeTwoSortedLists.ListNode listNode5 = new MergeTwoSortedLists.ListNode(7);
        MergeTwoSortedLists.ListNode listNode6 = new MergeTwoSortedLists.ListNode(4);

        listNode1.next = listNode2;

        listNode4.next = listNode5;

        new MergeTwoSortedLists().mergeTwoLists(listNode1, listNode4);
    }

}
