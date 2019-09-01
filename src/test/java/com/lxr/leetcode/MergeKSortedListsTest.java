package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2019-09-01.
 */
public class MergeKSortedListsTest {

    @Test
    public void mergeKLists() {

        MergeKSortedLists.ListNode listNode1 = createListNode(new int[]{1, 2, 3, 3, 4});
        MergeKSortedLists.ListNode listNode2 = createListNode(new int[]{2, 2, 6, 7, 7});
        MergeKSortedLists.ListNode listNode3 = createListNode(new int[]{1, 1, 4, 5, 6});

        MergeKSortedLists.ListNode[] list = new MergeKSortedLists.ListNode[]{listNode1, listNode2, listNode3};

        MergeKSortedLists.ListNode kListNode = new MergeKSortedLists().mergeKLists(list);
        System.out.println(kListNode);

    }


    private MergeKSortedLists.ListNode createListNode(int[] list) {
        MergeKSortedLists.ListNode listNode = null;

        for (int i = list.length - 1; i >= 0; i--) {
            MergeKSortedLists.ListNode lll = new MergeKSortedLists.ListNode(list[i]);
            lll.next = listNode;
            listNode = lll;
        }

        return listNode;
    }

}
