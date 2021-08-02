package com.lxr.leetcode;

import org.junit.Test;

import java.util.List;

public class GenerateParenthesesTest {

    @Test
    public void generateParenthesis() {
        int n = 5;

        List<String> ans = new GenerateParentheses().generateParenthesis(n);

        System.out.println(ans);
    }
}
