package com.lxr.leetcode;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 * <p>
 * eg1.
 * Input: [1,2,0]
 * Output: 3
 * <p>
 * eg2.
 * Input: [3,4,-1,1]
 * Output: 2
 * <p>
 * eg3.
 * Input: [7,8,9,11,12]
 * Output: 1
 * <p>
 * Note:
 * Your algorithm should run in O(n) time and uses constant extra space.
 */
public class FirstMissingPositive {

    /**
     * 0ms    100.00% Run time
     * 34.6MB 100.00% Memory
     */
    public int firstMissingPositive(int[] nums) {
        // Arrays.sort(nums); 该排序的时间复杂度为O(nlogn)，所以不能使用

        int ans = 1;

        // 由于int只能存储32个数的状态，因此直接采用数组
        // 利用warehouse来存储每个位置的状态，1代表nums中有该值，否则无
        // 本来容量想直接设置为Integer.MAX_VALUE的，但是没必要，而且会OutOfMemory
        // warehouse容量最大不需要超过nums的长度+2
        boolean[] warehouse = new boolean[nums.length + 2];

        // 时间复杂度:O(n)
        for (int index : nums) {
            if (index <= 0 || index >= warehouse.length) {
                continue;
            }

            warehouse[index] = true;
        }

        // 时间复杂度:O(n)
        for (int i = 1; i < warehouse.length; i++) {
            if (!warehouse[i]) {
                ans = i;
                break;
            }
        }

        return ans;
    }

}
