package com.lxr.leetcode;

/**
 * Implement next permutation, which rearranges numbers into
 * the lexicographically next greater permutation of numbers.
 * <p>
 * If such arrangement is not possible, it must rearrange it
 * as the lowest possible order (ie, sorted in ascending order).
 * <p>
 * The replacement must be in-place and use only constant extra memory.
 * <p>
 * Here are some examples. Inputs are in the left-hand column
 * and its corresponding outputs are in the right-hand column.
 * <p>
 * eg.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation {

    /**
     * 0ms     100.00% Run time
     * 41.5MB  31.00% Memory
     */
    public void nextPermutation(int[] nums) {
        boolean finded = false;

        for (int i = nums.length - 1; i > 0; i--) {
            // 如果前一个数比后一个数小（i-1之后的必定为倒序），则找到i-1之后的最接近i-1并且比i-1大的数
            if (nums[i] > nums[i - 1]) {
                int index = nums.length - 1;
                while (nums[index] <= nums[i - 1]) {
                    index--;
                }

                // 交换index索引处的值与i-1索引处的值
                int temp = nums[i - 1];
                nums[i - 1] = nums[index];
                nums[index] = temp;

                // 重排列i-1之后的数组
                sortRest(nums, i - 1);

                finded = true;

                break;
            }
        }

        // 如果全倒序
        if (!finded) {
            sortRest(nums, -1);
        }
    }

    // 将index后边的重新排列
    private void sortRest(int[] nums, int index) {
        int x = index + 1;
        int y = nums.length - 1;

        while (x <= y) {
            int temp = nums[y];
            nums[y] = nums[x];
            nums[x] = temp;
            x++;
            y--;
        }
    }

}
