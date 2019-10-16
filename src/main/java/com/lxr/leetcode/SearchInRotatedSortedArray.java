package com.lxr.leetcode;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search.
 * If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * eg1.
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * <p>
 * eg2.
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchInRotatedSortedArray {

    /**
     * 0ms     100.00% Run time
     * 36.5MB  100.00% Memory
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int a1 = 0;
        int a2 = nums.length - 1;

        int first = nums[a1];
        int last = nums[a2];

        // nums的首尾一定是相邻的两个数
        if (target < first && target > last) {
            return -1;
        }

        // 此时才是被切割的
        if (first > last) {
            // 找到切割的点,即最小值(时间复杂度为logn)
            while (a2 > a1) {
                int mIndex = (a1 + a2) / 2;
                int temp = nums[mIndex];

                if (temp >= first) {
                    a1 = mIndex + 1;
                } else if (temp <= last) {
                    a2 = mIndex;
                }
            }
        }

        if (target <= last) {
            a2 = nums.length - 1;
        }

        if (target >= first) {
            a1 = 0;
        }

        int ans = -1;

        // 二分法找到该值(时间复杂度为logn)
        while (a2 >= a1) {
            int mIndex = (a1 + a2) / 2;
            int temp = nums[mIndex];

            if (target > temp) {
                a1 = mIndex + 1;
            } else if (target < temp) {
                a2 = mIndex - 1;
            } else {
                ans = mIndex;
                break;
            }
        }

        return ans;
    }

}
