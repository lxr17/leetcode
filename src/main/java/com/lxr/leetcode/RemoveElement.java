package com.lxr.leetcode;

/**
 * Given an array nums and a value val,
 * remove all instances of that value in-place and return the new length.
 * <p>
 * Do not allocate extra space for another array,
 * you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * The order of elements can be changed.
 * It doesn't matter what you leave beyond the new length.
 * <p>
 * eg1.
 * Given nums = [3,2,2,3], val = 3,
 * Your function should return length = 2, with the first two elements of nums being 2.
 * It doesn't matter what you leave beyond the returned length.
 * <p>
 * eg2.
 * Given nums = [0,1,2,2,3,0,4,2], val = 2,
 * Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
 * Note that the order of those five elements can be arbitrary.
 * It doesn't matter what values are set beyond the returned length.
 */
public class RemoveElement {

    /**
     * 0ms    100.00% Run time
     * 35.2 MB 100.00% Memory
     */
    public int removeElement(int[] nums, int val) {
        int s = 0;

        for (int i : nums) {
            if (i != val) {
                nums[s] = i;
                s++;
            }
        }

        return s;
    }

}
