package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by he_jhua on 2019/4/3.
 */
public class LongestSubstringWithoutRepeatingCharactersTest {

    @Test
    public void lengthOfLongestSubstring() {
        String s = "pwwkew";
        int max = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s);

        System.out.println(max);
    }
}
