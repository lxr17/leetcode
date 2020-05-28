package com.lxr.leetcode;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * eg1.
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * eg2.
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 * <p>
 * Constraints:
 * 1 <= nums.length <= 3 * 10^4
 * 0 <= nums[i][j] <= 10^5
 */
public class JumpGame {

    /**
     * 1ms    98.90% Run time
     * 41.8MB 24.79% Memory
     */
    public boolean canJump(int[] nums) {
        int index = 0;// 当前索引
        int jump = nums[0];// 从当前索引将要跳的格数

        while (index < nums.length - 1 && jump > 0) {
            // 重置将要跳的格数
            if (nums[index] > jump) {
                jump = nums[index];
            }

            // 跳一格
            index++;
            jump--;

            // 防止出现[1, 2, 3]的错误
            if (jump == 0 && index < nums.length - 1) {
                jump = nums[index];
            }
        }

        return index == nums.length - 1;
    }

}
