package com.lxr.leetcode;

/**
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 * <p>
 * eg.
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 */
public class LongestPalindromicSubstring {

    /**
     * 43ms    40.90% Run time
     * 38.3MB  49.35% Memory
     */
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }

        String longestPalindrome = s.substring(0, 1);
        int maxLength = longestPalindrome.length();

        if (s.length() == 1) {
            return longestPalindrome;
        }

        // assume the length of longest palindromic is odd
        for (int i = 1; i < s.length(); i++) {
            int j = 1;
            while (i - j >= 0 && i + j < s.length()) {
                if (s.charAt(i - j) == s.charAt(i + j)) {
                    if (i - j == 0 || i + j == s.length() - 1) {
                        if (2 * j + 1 > maxLength) {
                            longestPalindrome = s.substring(i - j, i + j + 1);
                            maxLength = 2 * j + 1;
                        }
                        break;
                    }
                    j++;
                } else {
                    if (2 * j - 1 > maxLength) {
                        longestPalindrome = s.substring(i - j + 1, i + j);
                        maxLength = 2 * j - 1;
                    }
                    break;
                }
            }
        }

        // assume the length of longest palindromic is even
        for (int i = 1; i < s.length(); i++) {
            int j = 1;
            while (i - j >= 0 && i + j - 1 < s.length()) {
                if (s.charAt(i - j) == s.charAt(i + j - 1)) {
                    if (i - j == 0 || i + j - 1 == s.length() - 1) {
                        if (2 * j > maxLength) {
                            longestPalindrome = s.substring(i - j, i + j);
                            maxLength = 2 * j;
                        }
                        break;
                    }
                    j++;
                } else {
                    if (2 * j - 2 > maxLength) {
                        longestPalindrome = s.substring(i - j + 1, i + j - 1);
                        maxLength = 2 * j - 2;
                    }
                    break;
                }
            }
        }

        return longestPalindrome;
    }

}
