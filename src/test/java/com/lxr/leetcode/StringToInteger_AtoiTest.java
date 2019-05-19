package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2019-05-19.
 */
public class StringToInteger_AtoiTest {

    @Test
    public void myAtoi() {
        String str = "    -000000000002022222222cds  l";
        System.out.println(new StringToInteger_Atoi().myAtoi(str));
    }
}
