package com.lxr.leetcode;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * eg.
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * Note:
 * You can assume that you can always reach the last index.
 */
public class JumpGameII {

    /**
     * 129ms  27.06% Run time
     * 38MB   100.00% Memory
     */
    public int jump(int[] nums) {
        // 1.找出第一个能跳到last index的索引记作p1
        // 2.找出第一个能跳到p1的索引记作p2
        // ...
        // n.直到找到索引0

        int step = 0;// 跳的步数
        int reach = nums.length - 1;// 需要到达点

        while (reach > 0) {
            for (int i = 0; i < reach; i++) {
                if (i + nums[i] >= reach) {
                    reach = i;
                    ++step;
                    break;
                }
            }
        }

        return step;
    }

}
