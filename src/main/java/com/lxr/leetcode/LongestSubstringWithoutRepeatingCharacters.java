package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * eg.
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * 65ms 18.94% Run time
 * 39.8MB 16.26% Memory
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        List<Character> characters = new ArrayList<>();

        if (s == null) {
            return max;
        }

        // change the char[] to Character[]
        for (char ch : s.toCharArray()) {
            characters.add(ch);
        }

        if (s.length() > 0) {
            max = 1;
        }

        for (int i = 0; i < s.length(); i++) {
            // needn't continue
            if (i + max >= s.length()) {
                break;
            }

            // determine if the string contains duplicate characters
            StringBuilder first = new StringBuilder(s.substring(i, i + max));
            Set set = new HashSet(characters.subList(i, i + max));
            if (first.length() > set.size()) {
                continue;
            }

            // grow the first string
            for (int j = i + max; j < s.length(); j++) {
                if (first.indexOf(Character.toString(s.charAt(j))) == -1) {
                    first.append(s.charAt(j));
                } else {
                    break;
                }
            }

            if (max < first.length()) {
                max = first.length();
            }

        }

        return max;
    }

}
