package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2019-12-30.
 */
public class WildcardMatchingTest {

    @Test
    public void isMatch() {
//        String s = "aaaa";
//        String p = "a*a";
        String s = "ab";
        String p = "*a*";

        System.out.println(new WildcardMatching().isMatch(s, p));
    }

}
