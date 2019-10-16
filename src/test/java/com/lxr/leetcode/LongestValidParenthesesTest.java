package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2019-10-15.
 */
public class LongestValidParenthesesTest {

    @Test
    public void longestValidParentheses() {
        String s = "()(()";
        String s1 = "()(())";

        int max = new LongestValidParentheses().longestValidParentheses(s1);

        System.out.println(max);
    }

}
