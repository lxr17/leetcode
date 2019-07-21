package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2019-07-21.
 */
public class IntegerToRomanTest {

    @Test
    public void intToRoman() {
        int num = 777;

        String ss = new IntegerToRoman().intToRoman(num);
        System.out.println(ss);
    }
}
