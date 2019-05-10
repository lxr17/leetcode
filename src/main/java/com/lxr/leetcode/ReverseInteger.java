package com.lxr.leetcode;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * eg.
 * Input: 123
 * Output: 321
 * <p>
 * Input: -123
 * Output: -321
 * <p>
 * Input: 120
 * Output: 21
 */
public class ReverseInteger {

    /**
     * 2ms    71.16% Run time
     * 32.9 MB 100.00% Memory
     */
    public int reverse(int x) {
        try {
            if (x > 0) {
                return Integer.parseInt(new StringBuffer(Integer.toString(x)).reverse().toString());
            } else {
                return -Integer.parseInt(new StringBuffer(Integer.toString(-x)).reverse().toString());
            }
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

}
