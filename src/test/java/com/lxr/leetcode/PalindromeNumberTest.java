package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2019-05-26.
 */
public class PalindromeNumberTest {

    @Test
    public void isPalindrome() {
        int x = -121;
        boolean b = new PalindromeNumber().isPalindrome(x);

        System.out.println(b);
    }
}
