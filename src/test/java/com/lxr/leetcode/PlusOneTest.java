package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2020/6/5.
 */
public class PlusOneTest {

    @Test
    public void plusOne() {
        int[] digits = new int[]{};

        int[] ans = new PlusOne().plusOne(digits);

        for (int in : ans) {
            System.out.print(in + " ");
        }
    }

}
