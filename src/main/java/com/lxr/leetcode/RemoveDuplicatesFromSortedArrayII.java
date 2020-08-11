package com.lxr.leetcode;

/**
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * eg1.
 * Given nums = [1,1,1,2,2,3],
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 * It doesn't matter what you leave beyond the returned length.
 * <p>
 * eg2.
 * Given nums = [0,0,1,1,1,1,2,3,3],
 * Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
 * It doesn't matter what values are set beyond the returned length.
 * <p>
 * Clarification:
 * Confused why the returned value is an integer but your answer is an array?
 * Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
 * Internally you can think of this:
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 * <p>
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 */
public class RemoveDuplicatesFromSortedArrayII {

    /**
     * 0ms     100.00% Run time
     * 39.8MB  55.66% Memory
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        // 需要返回的长度
        int size = 1;

        // 当前数字重复次数
        int repeat = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[size - 1]) {
                if (repeat < 2) {
                    nums[size] = nums[i];
                    size++;
                }

                repeat++;
            } else {
                nums[size] = nums[i];
                size++;

                repeat = 1;
            }
        }

        return size;
    }

}
