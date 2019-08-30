package com.lxr.leetcode;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * <p>
 * Note that an empty string is also considered valid.
 * <p>
 * eg.
 * Input: "()"
 * Output: true
 * <p>
 * Input: "()[]{}"
 * Output: true
 * <p>
 * Input: "(]"
 * Output: false
 * <p>
 * Input: "([)]"
 * Output: false
 * <p>
 * Input: "{[]}"
 * Output: true
 */
public class ValidParentheses {

    /**
     * 2ms     60.63% Run time
     * 34.4 MB 100.00% Memory
     */
    public boolean isValid(String s) {
        // 利用栈的特性
        Stack<Character> stack = new Stack<>();

        if (s == null || s.length() == 0) {
            return true;
        }

        // 注意判空
        for (Character ch : s.toCharArray()) {
            if (!stack.empty() && ')' == ch && '(' == stack.peek()) {
                stack.pop();
            } else if (!stack.empty() && ']' == ch && '[' == stack.peek()) {
                stack.pop();
            } else if (!stack.empty() && '}' == ch && '{' == stack.peek()) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.empty();
    }

}
