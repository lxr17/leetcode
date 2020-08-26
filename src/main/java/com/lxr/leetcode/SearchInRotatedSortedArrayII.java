package com.lxr.leetcode;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return true, otherwise return false.
 * <p>
 * eg1.
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * <p>
 * eg2.
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * <p>
 * Follow up:
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 */
public class SearchInRotatedSortedArrayII {

    /**
     * 0ms     100.00% Run time
     * 39.4MB  62.33% Memory
     */
    public boolean search(int[] nums, int target) {
        // 原本思路：
        // 1. 找到分割点
        // 2. 判断target在哪一边
        // 3. 针对于那一边采用二分法
        // 但是：步骤1很难达到，于是就用了简单粗暴的直接遍历

        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }

        return false;
    }

}
