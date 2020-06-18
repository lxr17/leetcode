package com.lxr.leetcode;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note: You are not suppose to use the library's sort function for this problem.
 * <p>
 * eg.
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * <p>
 * Follow up:
 * <p>
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */
public class SortColors {

    /**
     * 0ms     100.00% Run time
     * 38MB    57.51% Memory
     */
    public void sortColors(int[] nums) {
        // 最后一个0的索引
        int oneIndex = -1;
        // 第一个2的索引
        int twoIndex = nums.length;
        // 当前索引
        int currentIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            // 所有的2不需要再次遍历
            if (i >= twoIndex) {
                break;
            }

            if (nums[i] == 2) {
                // 第一个2的前一个元素与该元素作交换
                nums[i] = nums[twoIndex - 1];
                nums[twoIndex - 1] = 2;
                twoIndex--;

                // 由于被换上来的数字有可能还需要作交换，所以得重新比较一次
                i--;
            } else if (nums[i] == 0) {
                // 最后一个0的后一个元素与该元素作交换
                nums[i] = nums[oneIndex + 1];
                nums[oneIndex + 1] = 0;
                oneIndex++;

                // 这里不需要i--了，因为被换上来的数字只可能为1（只有在oneIndex+1==i的时候才为0）
            }
        }
    }

}
