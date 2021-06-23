package com.lxr.leetcode;

import org.junit.Test;

public class DecodeWaysTest {

    @Test
    public void numDecodings() {
        String test = "11111111111111111111111111111";
        int ans = new DecodeWays().numDecodings(test);
        System.out.println(ans);
    }

    @Test
    public void numDecodings2() {
        String test = "111111111111111111111111111111111111111111111";
        int ans = new DecodeWays().numDecodings2(test);
        System.out.println(ans);
    }

}
