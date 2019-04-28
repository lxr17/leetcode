package com.lxr.leetcode;

import org.junit.Test;

public class LongestPalindromicSubstringTest {

    @Test
    public void longestPalindrome() {
        String s = "abcdfghhgfdcdfa";
//        String s = "babad";
//        String s = "";
//        String s = "z";
        String ans = new LongestPalindromicSubstring().longestPalindrome(s);

        System.out.println(ans);
    }

}
