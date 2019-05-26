package com.lxr.leetcode;

/**
 * Determine whether an integer is a palindrome.
 * An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * eg.
 * Input: 121
 * Output: true
 * <p>
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to
 * left, it becomes 121-. Therefore it is not a palindrome.
 * <p>
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * <p>
 * Follow up:
 * Coud you solve it without converting the integer to a string?
 */
public class PalindromeNumber {

    /**
     * 8ms    68.82% Run time
     * 35.1 MB 71.77% Memory
     */
    public boolean isPalindrome(int x) {
        boolean isPalindrome = true;
        String strX = Integer.toString(x);

        for (int i = 0; i < strX.length() / 2; i++) {
            if (strX.charAt(i) != strX.charAt(strX.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }

}
