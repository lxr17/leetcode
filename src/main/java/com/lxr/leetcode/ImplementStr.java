package com.lxr.leetcode;

/**
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 * <p>
 * eg1.
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * <p>
 * eg2.
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * <p>
 * Clarification:
 * What should we return when needle is an empty string?
 * This is a great question to ask during an interview.
 * <p>
 * For the purpose of this problem, we will return 0 when needle is an empty string.
 * This is consistent to C's strstr() and Java's indexOf().
 */
public class ImplementStr {

    /**
     * 0ms    100.00% Run time
     * 37.7 MB 67.94% Memory
     */
    public int strStr(String haystack, String needle) {
        // needle is a empty string
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        // needle比haystack长
        if (haystack == null || haystack.length() < needle.length()) {
            return -1;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            String sub = haystack.substring(i, i + needle.length());

            if (needle.equals(sub)) {
                return i;
            }
        }

        return -1;
    }

}
