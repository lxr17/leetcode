package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2019-10-08.
 */
public class DivideTwoIntegersTest {

    @Test
    public void divide() {
        int a = 2147483647;
        int b = 2;

        int ans = new DivideTwoIntegers().divide(a, b);

        int anss = a / b;

        System.out.println(ans);
        System.out.println(anss);
    }

}
