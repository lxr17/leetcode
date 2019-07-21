package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2019-07-21.
 */
public class RomanToIntegerTest {

    @Test
    public void romanToInt() {
        String sss = "MCMXCIV";

        int sum = new RomanToInteger().romanToInt(sss);
        System.out.println(sum);
    }

}
