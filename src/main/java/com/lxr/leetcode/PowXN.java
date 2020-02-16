package com.lxr.leetcode;

/**
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 * <p>
 * eg.
 * Input: 2.00000, 10
 * Output: 1024.00000
 * <p>
 * Input: 2.10000, 3
 * Output: 9.26100
 * <p>
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
 * <p>
 * Note:
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
 */
public class PowXN {

    /**
     * 0ms    100.00% Run time
     * 37.1MB 5.88% Memory
     */
    public double myPow(double x, int n) {
        if (x == 0 || x == 1) {
            return x;
        }

        if (n < 0) {
            return pow(1 / x, n);
        } else {
            return pow(x, n);
        }
    }

    /**
     * 此时n的正负不影响结果
     *
     * @param x
     * @param n
     * @return
     */
    private double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        // x^n=(x^2)^(n/2)
        return (pow(x * x, n / 2) * (n % 2 == 0 ? 1 : x));
    }

}
