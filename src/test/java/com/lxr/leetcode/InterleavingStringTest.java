package com.lxr.leetcode;

import org.junit.Test;

public class InterleavingStringTest {

    @Test
    public void isInterleave() {
        String s1 = "aabd";
        String s2 = "abdc";
        String s3 = "aabdabcd";

        boolean ans = new InterleavingString().isInterleave(s1, s2, s3);

        System.out.println(ans);
    }

    @Test
    public void isInterleave2() {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";

        boolean ans = new InterleavingString().isInterleave2(s1, s2, s3);

        System.out.println(ans);
    }
}
