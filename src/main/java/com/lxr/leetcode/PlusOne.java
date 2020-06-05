package com.lxr.leetcode;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * eg1.
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * <p>
 * eg2.
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */
public class PlusOne {

    /**
     * 0ms     100.00% Run time
     * 37.7MB  89.06% Memory
     */
    public int[] plusOne(int[] digits) {
        int carry = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + carry;
            carry = digits[i] / 10;
            digits[i] = digits[i] % 10;

            if (carry == 0) {
                break;
            }
        }

        if (carry > 0) {
            int[] ans = new int[digits.length + 1];
            ans[0] = carry;
            System.arraycopy(digits, 0, ans, 1, digits.length);

            return ans;
        } else {
            return digits;
        }
    }

}
