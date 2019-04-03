package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by he_jhua on 2019/4/3.
 */
public class AddTwoNumbersTest {

    @Test
    public void addTwoNumbers() {
        AddTwoNumbers.ListNode node1 = createListNode("1234567890");
        AddTwoNumbers.ListNode node2 = createListNode("1144510201");

        AddTwoNumbers.ListNode result = new AddTwoNumbers().addTwoNumbers(node1, node2);

        System.out.println("[" + listNodeToString(result) + "]");
    }

    /**
     * 通过String创建ListNode
     *
     * @param nums
     * @return
     */
    private AddTwoNumbers.ListNode createListNode(String nums) {
        char[] chs = nums.toCharArray();

        AddTwoNumbers.ListNode node = null;
        for (char ch : chs) {
            AddTwoNumbers.ListNode parent = new AddTwoNumbers.ListNode(Integer.parseInt(Character.toString(ch)));
            parent.next = node;
            node = parent;
        }

        return node;
    }

    /**
     * 将ListNode输出成字符串
     *
     * @param node
     * @return
     */
    private String listNodeToString(AddTwoNumbers.ListNode node) {
        StringBuilder sb = new StringBuilder(Integer.toString(node.val));

        while (node.next != null) {
            node = node.next;
            sb.append(", ").append(node.val);
        }

        return sb.reverse().toString();
    }
}
