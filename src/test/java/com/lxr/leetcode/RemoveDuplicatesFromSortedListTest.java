package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2020-08-26.
 */
public class RemoveDuplicatesFromSortedListTest {

    @Test
    public void deleteDuplicates() {
        int[] nums = new int[]{1, 1, 2, 2, 3, 3, 4, 5, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7};

        RemoveDuplicatesFromSortedList.ListNode listNode = generateList(nums);

        RemoveDuplicatesFromSortedList.ListNode ans = new RemoveDuplicatesFromSortedList().deleteDuplicates(listNode);

        System.out.println(ans);
    }

    public RemoveDuplicatesFromSortedList.ListNode generateList(int[] nums) {
        RemoveDuplicatesFromSortedList.ListNode listNode = new RemoveDuplicatesFromSortedList.ListNode(nums[0]);
        RemoveDuplicatesFromSortedList.ListNode head = listNode;

        for (int i = 1; i < nums.length; i++) {
            listNode.next = new RemoveDuplicatesFromSortedList.ListNode(nums[i]);
            listNode = listNode.next;
        }

        return head;
    }

}
