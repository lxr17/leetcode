package com.lxr.leetcode;

import java.math.BigInteger;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * <p>
 * eg1.
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * <p>
 * eg2.
 * Input: m = 7, n = 3
 * Output: 28
 */
public class UniquePaths {

    /**
     * 3ms    15.77% Run time
     * 37MB   5.10% Memory
     */
    public int uniquePaths(int m, int n) {
        return Integer.parseInt(factorial(m + n - 2).divide(factorial(m - 1).multiply(factorial(n - 1))).toString());
    }

    /**
     * 计算n!
     */
    private BigInteger factorial(int n) {
        BigInteger ans = new BigInteger("1");

        for (int i = 2; i <= n; i++) {
            ans = ans.multiply(new BigInteger(Integer.toString(i)));
        }

        return ans;
    }

}
