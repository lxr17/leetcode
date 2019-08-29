package com.lxr.leetcode;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target,
 * find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 * <p>
 * eg.
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class _3SumClosest {

    /**
     * 9ms      13.77% Run time
     * 36.3MB  100.00% Memory
     */
    public int threeSumClosest(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);

        int closest = Integer.MAX_VALUE;

        // i为第一个数的索引
        for (int i = 0; i < nums.length - 2; i++) {

            // j为第二个数的索引
            for (int j = i + 1; j < nums.length - 1; j++) {
                int rest = target - nums[i] - nums[j];
                int leftIndex = j + 1;
                int rightIndex = nums.length - 1;

                // 这两种情况找出来的值一定比closest大（需要对closest作判断）
                if (closest != Integer.MAX_VALUE
                        && (nums[i] + nums[j] + nums[leftIndex] - target > Math.abs(closest - target)
                        || target - (nums[i] + nums[j] + nums[rightIndex]) > Math.abs(closest - target))) {
                    break;
                }

                int matchIndex = leftIndex;

                // 找到余下中离rest最近的数
                if (rest <= nums[leftIndex]) {
                    // 如果比最小的还小，那最接近的就是最小的
                    matchIndex = leftIndex;
                } else if (rest >= nums[rightIndex]) {
                    // 如果比最大的还大，那最接近的就是最大的
                    matchIndex = rightIndex;
                } else {
                    // 否则一定是中间的某个数
                    while (rightIndex - leftIndex >= 1) {
                        int middle = (rightIndex + leftIndex) / 2;
                        if (rest < nums[middle]) {
                            rightIndex = middle;
                        } else if (rest > nums[middle + 1]) {
                            leftIndex = middle + 1;
                        } else if (rest >= nums[middle] && rest <= nums[middle + 1]) {
                            leftIndex = middle;
                            rightIndex = middle + 1;

                            matchIndex = Math.abs(nums[i] + nums[j] + nums[leftIndex] - target)
                                    > Math.abs(nums[i] + nums[j] + nums[rightIndex] - target) ? rightIndex : leftIndex;
                            break;
                        }
                    }
                }

                // 需要对closest的最大值作判断
                if (closest == Integer.MAX_VALUE || Math.abs(nums[i] + nums[j] + nums[matchIndex] - target) < Math.abs(closest - target)) {
                    closest = nums[i] + nums[j] + nums[matchIndex];
                }
            }

        }

        return closest;
    }

}
