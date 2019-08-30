package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target,
 * are there elements a, b, c, and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note:
 * The solution set must not contain duplicate quadruplets.
 * <p>
 * eg.
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class _4Sum {

    /**
     * 288ms   5.02% Run time
     * 58.4MB  8.69% Memory
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);

        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }

        return findX(numsList, 4, target);
    }

    /**
     * 从source中找出size个数，使之和为sum，并返回所有的序列（不重复）
     *
     * @param source 序列
     * @param size   个数
     * @param sum    总和
     */
    public List<List<Integer>> findX(List<Integer> source, int size, int sum) {
        List<List<Integer>> list = new ArrayList<>();

        // 用二分法找到所需要的值
        if (size == 1) {
            int leftIndex = 0;
            int rightIndex = source.size() - 1;
            while (rightIndex - leftIndex > 1) {
                int middleIndex = (leftIndex + rightIndex) / 2;

                if (sum < source.get(middleIndex)) {
                    rightIndex = middleIndex;
                } else if (sum > source.get(middleIndex)) {
                    leftIndex = middleIndex;
                } else {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(sum);
                    list.add(ans);
                    break;
                }
            }

            // rightIndex - leftIndex == 1 的情况
            if (list.size() == 0) {
                if (sum == source.get(leftIndex) || sum == source.get(rightIndex)) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(sum);
                    list.add(ans);
                }
            }

            return list;
        }

        for (int i = 0; i < source.size() - size + 1; i++) {
            // 力求不重复
            if (i > 0 && source.get(i).equals(source.get(i - 1))) {
                continue;
            }

            int thisNum = source.get(i);

            // 获取剩余部分的序列
            List<List<Integer>> tempList = findX(source.subList(i + 1, source.size()), size - 1, sum - thisNum);

            // 拼上第一个数
            for (List<Integer> temp : tempList) {
                temp.add(0, thisNum);
                list.add(temp);
            }
        }

        return list;

    }

}
