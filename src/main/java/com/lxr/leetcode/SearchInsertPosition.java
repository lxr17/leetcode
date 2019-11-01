package com.lxr.leetcode;

/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * eg1.
 * Input: [1,3,5,6], 5
 * Output: 2
 * <p>
 * eg2.
 * Input: [1,3,5,6], 2
 * Output: 1
 * <p>
 * eg3.
 * Input: [1,3,5,6], 7
 * Output: 4
 * <p>
 * eg4.
 * Input: [1,3,5,6], 0
 * Output: 0
 */
public class SearchInsertPosition {

    /**
     * 0ms     100.00% Run time
     * 37.9MB  100.00% Memory
     */
    public int searchInsert(int[] nums, int target) {
        // 如果数组是空的，那索引就是0
        if (nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        // 如果找到了，就return；如果没找着，则right-left=1
        while (right - left > 1) {
            int middle = (left + right) / 2;

            if (target == nums[middle]) {
                return middle;
            } else if (target > nums[middle]) {
                left = middle;
            } else {
                right = middle;
            }
        }

        if (target <= nums[left]) {
            return left;
        } else if (target <= nums[right]) {
            return right;
        } else {
            return right + 1;
        }
    }

}
