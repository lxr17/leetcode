package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2019-06-10.
 */
public class RegularExpressionMatchingTest {

    @Test
    public void isMatch() {
        boolean b = new RegularExpressionMatching().isMatch("aazxsss", "a.zxs*");
        System.out.println(b);
    }
}
