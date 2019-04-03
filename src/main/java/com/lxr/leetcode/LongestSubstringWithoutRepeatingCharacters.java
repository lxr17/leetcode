package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * eg.
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * 97ms 12.27% Run time
 * 40MB 14.87% Memory
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        char[] chs = s.toCharArray();

        int max = 0;

        List<Character> maxStrings = new ArrayList<>();

        // find the longest substring from every index
        for (int i = 0; i < chs.length; i++) {
            // needn't find where the rest < max
            if (max >= chs.length - i) {
                break;
            }

            // find the longest substring from index i
            for (int j = i; j < chs.length; j++) {
                if (!maxStrings.contains(chs[j])) {
                    maxStrings.add(chs[j]);
                } else {
                    break;
                }
            }

            if (max < maxStrings.size()) {
                max = maxStrings.size();
            }
            maxStrings.clear();
        }

        return max;
    }

}
