package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2020/6/18.
 */
public class MinimumWindowSubstringTest {

    @Test
    public void minWindow() {
        String s = "a";
        String t = "aa";

        String ans = new MinimumWindowSubstring().minWindow(s, t);

        System.out.println(ans);
    }

    @Test
    public void minWindow2() {
        String s = "cabefgecdaecf";
        String t = "cae";

        String ans = new MinimumWindowSubstring().minWindow2(s, t);

        System.out.println(ans);
    }

    @Test
    public void minWindow3() {
        String s = "cabefgecdaecf";
        String t = "cae";

        String ans = new MinimumWindowSubstring().minWindow3(s, t);

        System.out.println(ans);
    }

}
