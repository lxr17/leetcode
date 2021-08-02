package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to
 * generate all combinations of well-formed parentheses.
 * <p>
 * eg.
 * Given n = 3, a solution set is:
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class GenerateParentheses {

    /**
     * 2ms      28.71% Run time
     * 39.2MB   57.01% Memory
     */
    public List<String> generateParenthesis(int n) {
        List<Store> ans = new ArrayList<>();
        List<Store> temp = new ArrayList<>();

        int count = n * 2;

        Store first = new Store();
        first.str = "(";
        first.leftCount = 1;
        first.rightCount = 0;
        ans.add(first);

        for (int i = 1; i < count; i++) {
            temp.clear();
            for (int j = 0; j < ans.size(); j++) {
                Store cur = ans.get(j);

                // 加左括号
                if (cur.leftCount < n) {
                    Store left = new Store();
                    left.str = cur.str + "(";
                    left.leftCount = cur.leftCount + 1;
                    left.rightCount = cur.rightCount;
                    temp.add(left);
                }

                // 加右括号
                if (cur.leftCount > cur.rightCount) {
                    Store right = new Store();
                    right.str = cur.str + ")";
                    right.leftCount = cur.leftCount;
                    right.rightCount = cur.rightCount + 1;
                    temp.add(right);
                }
            }

            ans.clear();
            ans.addAll(temp);
        }

        List<String> realAns = new ArrayList<>();
        for (Store store : ans) {
            realAns.add(store.str);
        }

        return realAns;
    }

    public static class Store {
        private String str;
        private int leftCount;
        private int rightCount;
    }
}
