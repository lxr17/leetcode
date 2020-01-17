package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums
 * such that a + b + c = 0? Find all unique triplets in the array
 * which gives the sum of zero.
 * <p>
 * Note:
 * The solution set must not contain duplicate triplets.
 * <p>
 * eg.
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class _3Sum {// 做一次测试提交。

    /**
     * 时间太长了
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[k]);

                        Collections.sort(ans);

                        if (!answers.contains(ans)) {
                            answers.add(ans);
                        }
                    }
                }
            }
        }

        return answers;
    }

    /**
     * 参考了某一solution
     * 37ms    43.92% Run time
     * 46.6MB  94.03% Memory
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            if (i > 0)
                while (i < len - 2 && nums[i - 1] == nums[i])
                    i++; // to exclude duplicates
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    triplets.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    j++;
                    k--;
                    while ((j < k) && (nums[j - 1] == nums[j])) // to exclude duplicates
                        j++;
                    while ((j < k) && (nums[k] == nums[k + 1])) // to exclude duplicates
                        k--;
                } else if (sum < 0) {
                    j++; // sum too low
                } else {
                    k--; // sum too high
                }
            }
        }
        return triplets;
    }
}
