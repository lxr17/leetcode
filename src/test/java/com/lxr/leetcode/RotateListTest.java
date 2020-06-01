package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2020/6/1.
 */
public class RotateListTest {

    @Test
    public void rotateRight() {
        RotateList.ListNode listNode = createListNode(new int[]{1});

        RotateList.ListNode ans = new RotateList().rotateRight(listNode, 5);

        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    private RotateList.ListNode createListNode(int[] params) {
        RotateList.ListNode ans = new RotateList.ListNode();
        RotateList.ListNode current = ans;

        current.val = params[0];

        for (int i = 1; i < params.length; i++) {
            RotateList.ListNode listNode = new RotateList.ListNode();
            listNode.val = params[i];

            current.next = listNode;
            current = listNode;
        }

        return ans;
    }

}
