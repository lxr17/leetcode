package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2020/11/2.
 */
public class ScrambleStringTest {

    @Test
    public void isScramble() {
        String s1 = "abb";
        String s2 = "bba";

        System.out.println(new ScrambleString().isScramble2(s1, s2));
    }

}
