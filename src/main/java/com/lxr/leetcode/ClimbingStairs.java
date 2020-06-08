package com.lxr.leetcode;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * eg1.
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * <p>
 * eg2.
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class ClimbingStairs {

    /**
     * 0ms     100.00% Run time
     * 38.3MB  5.05% Memory
     */
    public int climbStairs(int n) {
//        // 这是斐波那契数列
//        if (n == 1) {
//            // 此时只有一种：1
//            return 1;
//        } else if (n == 2) {
//            // 此时有两种：1、1；2
//            return 2;
//        } else {
//            // 走一步的后续情况 + 走两步的后续情况
//            return climbStairs(n - 1) + climbStairs(n - 2);
//        }

        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int first = 1;
        int second = 2;

        // 将递归转换成遍历
        for (int i = 2; i < n; i++) {
            int temp = second;
            second = first + second;
            first = temp;
        }

        return second;
    }

}
