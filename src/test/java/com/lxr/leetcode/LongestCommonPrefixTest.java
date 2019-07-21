package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2019-07-21.
 */
public class LongestCommonPrefixTest {

    @Test
    public void longestCommonPrefix() {
        String[] strs = new String[]{"flowzsx", "flo", "flow"};

        String ss = new LongestCommonPrefix().longestCommonPrefix(strs);

        System.out.println(ss);
    }

}
