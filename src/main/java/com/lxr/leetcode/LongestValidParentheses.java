package com.lxr.leetcode;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * eg1.
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * <p>
 * eg2.
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */
public class LongestValidParentheses {

    /**
     * 14ms   7.15% Run time
     * 39.5MB 5.88% Memory
     */
    public int longestValidParentheses(String s) {
        // 记录最长匹配串的长度
        int max = 0;

        Stack<String> stacks = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stacks.empty() || '(' == s.charAt(i)) {// 如果当前字符是左括号或者栈为空，则入栈
                stacks.push(Character.toString(s.charAt(i)));
            } else if ("(".equals(stacks.peek())) {// 如果栈顶是左括号（此时当前字符一定是右括号）
                stacks.pop();

                // 找到当前最大长度
                int temp = 0;

                // 入栈之前看看栈顶是不是数字
                if (!stacks.empty() && !"(".equals(stacks.peek()) && !")".equals(stacks.peek())) {
                    temp = temp + Integer.parseInt(stacks.pop());
                }

                temp += 2;
                if (temp > max) {
                    max = temp;
                }

                stacks.push(Integer.toString(temp));
            } else if (")".equals(stacks.peek())) {// 如果栈顶是右括号（此时当前字符一定是右括号）
                stacks.push(")");
            } else {// 此时栈顶是数字

                // 获取栈顶的数字，并出栈
                int temp = Integer.parseInt(stacks.pop());

                // 如果此时栈顶的是左括号
                if (!stacks.empty() && "(".equals(stacks.peek())) {
                    stacks.pop();
                    temp += 2;

                    // 入栈之前看看栈顶是不是数字
                    if (!stacks.empty() && !"(".equals(stacks.peek()) && !")".equals(stacks.peek())) {
                        temp = temp + Integer.parseInt(stacks.pop());
                    }

                    stacks.push(Integer.toString(temp));

                    if (temp > max) {
                        max = temp;
                    }
                } else {
                    stacks.push(Integer.toString(temp));
                    stacks.push(")");
                }
            }
        }

        return max;
    }

}
