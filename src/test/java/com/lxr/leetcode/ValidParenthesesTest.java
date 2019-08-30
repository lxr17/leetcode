package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2019-08-30.
 */
public class ValidParenthesesTest {

    @Test
    public void isValid() {
        String test = "})";

        boolean isValid = new ValidParentheses().isValid(test);

        System.out.println(isValid);
    }

}
