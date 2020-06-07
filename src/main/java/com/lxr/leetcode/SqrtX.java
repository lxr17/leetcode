package com.lxr.leetcode;

/**
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * <p>
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 * <p>
 * eg1.
 * Input: 4
 * Output: 2
 * <p>
 * eg2.
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 * the decimal part is truncated, 2 is returned.
 */
public class SqrtX {

    /**
     * 1ms     100.00% Run time
     * 36.8MB  43.50% Memory
     */
    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }

}
