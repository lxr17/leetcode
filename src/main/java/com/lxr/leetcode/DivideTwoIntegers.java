package com.lxr.leetcode;

/**
 * Given two integers dividend and divisor,
 * divide two integers without using multiplication, division and mod operator.
 * <p>
 * Return the quotient after dividing dividend by divisor.
 * <p>
 * The integer division should truncate toward zero.
 * <p>
 * eg1.
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * <p>
 * eg2.
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * <p>
 * Note:
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store
 * integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
 * For the purpose of this problem, assume that your function returns 2^31 − 1
 * when the division result overflows.
 */
public class DivideTwoIntegers {

    /**
     * 6ms     12.55% Run time
     * 35.4 MB 6.06% Memory
     */
    public int divide(int dividend, int divisor) {
        char symble;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            symble = '-';
        } else {
            symble = '+';
        }

        // 正数化
        long mDividend = dividend;
        long mDivisor = divisor;
        if (mDividend < 0) {
            mDividend = -mDividend;
        }
        if (mDivisor < 0) {
            mDivisor = -mDivisor;
        }

        // 被除数
        StringBuilder dividendStr = new StringBuilder(Long.toString(mDividend));

        // 商
        StringBuilder ans = new StringBuilder("0");

        // 上一次的余数
        long lastMod = 0;

        while (dividendStr.length() > 0) {
            // 当前的被除数
            long curDividend = Long.parseLong(Long.toString(lastMod) + dividendStr.subSequence(0, 1));

            // 如果当前被除数比除数小
            if (curDividend < mDivisor) {
                lastMod = curDividend;
                dividendStr.delete(0, 1);

                // 不够的情况下要补零
                ans.append(0);
                continue;
            }

            // 计算商与余数
            long sum = 0;
            while (curDividend >= mDivisor) {
                curDividend -= mDivisor;
                sum++;
            }
            ans.append(sum);
            lastMod = curDividend;

            // 移除最近的一位
            dividendStr.delete(0, 1);
        }

        int realAns;
        try {
            realAns = Integer.parseInt(symble + ans.toString());
        } catch (Exception ex) {
            realAns = Integer.MAX_VALUE;
        }

        return realAns;
    }

}
