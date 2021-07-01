package com.lxr.leetcode;

import org.junit.Test;

public class ReverseLinkedListIITest {

    @Test
    public void reverseBetween() {
        ReverseLinkedListII.ListNode listNode = generateList(new int[]{1,2,3,4,5,6,7,8});

        ReverseLinkedListII.ListNode ans = new ReverseLinkedListII().reverseBetween(listNode, 5, 8);

        System.out.println(ans);
    }

    public ReverseLinkedListII.ListNode generateList(int[] nums) {
        ReverseLinkedListII.ListNode listNode = new ReverseLinkedListII.ListNode(nums[0]);
        ReverseLinkedListII.ListNode head = listNode;

        for (int i = 1; i < nums.length; i++) {
            listNode.next = new ReverseLinkedListII.ListNode(nums[i]);
            listNode = listNode.next;
        }

        return head;
    }

}
