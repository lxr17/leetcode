package com.lxr.leetcode;

import java.util.Arrays;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * eg.
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * <p>
 * 2ms    99.85% Run time
 * 38.1MB 88.71% Memory
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        // 将int编程long，保存index信息
        long[] longs = new long[nums.length];
        for (int k = 0; k < nums.length; k++) {
            long a = (((long) nums[k]) << 32) + k;
            longs[k] = a;
        }

        // 排序
        Arrays.sort(longs);

        // 找到确定的值，并获取其index
        for (int i = 0; i < longs.length - 1; i++) {
            if ((int) (longs[i] >> 32) + (int) (longs[longs.length - 1] >> 32) >= target) {
                for (int j = i + 1; j < longs.length; j++) {
                    if ((int) (longs[i] >> 32) + (int) (longs[j] >> 32) == target) {
                        return new int[]{(int) (longs[i]), (int) (longs[j])};
                    }
                }
            }
        }

        return null;
    }

}
