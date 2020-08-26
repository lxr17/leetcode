package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2020-08-26.
 */
public class RemoveDuplicatesFromSortedListIITest {

    @Test
    public void deleteDuplicates() {
        int[] nums = new int[]{1, 2, 2};

        RemoveDuplicatesFromSortedListII.ListNode listNode = generateList(nums);

        RemoveDuplicatesFromSortedListII.ListNode ans = new RemoveDuplicatesFromSortedListII().deleteDuplicates(listNode);

        System.out.println(ans);
    }

    public RemoveDuplicatesFromSortedListII.ListNode generateList(int[] nums) {
        RemoveDuplicatesFromSortedListII.ListNode listNode = new RemoveDuplicatesFromSortedListII.ListNode(nums[0]);
        RemoveDuplicatesFromSortedListII.ListNode head = listNode;

        for (int i = 1; i < nums.length; i++) {
            listNode.next = new RemoveDuplicatesFromSortedListII.ListNode(nums[i]);
            listNode = listNode.next;
        }

        return head;
    }

}
