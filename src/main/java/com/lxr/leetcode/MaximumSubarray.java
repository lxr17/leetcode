package com.lxr.leetcode;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * e.g.
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * <p>
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray {

    /**
     * 0ms     100.00% Run time
     * 41.8MB  5.16% Memory
     */
    public int maxSubArray(int[] nums) {
        // 思路
        // 1. 记start为0
        // 2. 从start开始遍历
        // 3. 如果start到当前索引之间的数之和大于零，start不变，否则start等于当前的索引，继续遍历

        int max = nums[0];

        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];

            if (sum < 0) {
                sum = temp;
            } else if (sum + temp > 0) {
                sum += temp;
            } else {
                sum = temp;
            }

            if (sum > max) {
                max = sum;
            }
        }

        return max;
    }

}
