package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2019-12-24.
 */
public class MultiplyStringsTest {

    @Test
    public void multiply() {
        String num1 = "1111111111111111111111111111111111111111";
        String num2 = "0";

        String ans = new MultiplyStrings().multiply(num1, num2);

        System.out.println(ans);
    }

}
