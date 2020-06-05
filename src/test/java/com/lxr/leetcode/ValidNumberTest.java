package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2020/6/5.
 */
public class ValidNumberTest {

    @Test
    public void isNumber() {
        String s = "+.";

        boolean isNumber = new ValidNumber().isNumber(s);

        System.out.println(isNumber);
    }

}
