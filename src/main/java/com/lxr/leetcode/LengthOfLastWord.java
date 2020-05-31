package com.lxr.leetcode;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a maximal substring consisting of non-space characters only.
 * <p>
 * eg.
 * Input: "Hello World"
 * Output: 5
 */
public class LengthOfLastWord {

    /**
     * 1ms     41.93% Run time
     * 37.8MB  7.57% Memory
     */
    public int lengthOfLastWord(String s) {
        String[] strings = s.split(" ");

        if (strings.length == 0) {
            return 0;
        }

        return strings[strings.length - 1].length();
    }

}
