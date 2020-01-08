package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 * <p>
 * eg.
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Permutations {

    /**
     * 1ms     92.85% Run time
     * 37.4MB  95.74% Memory
     */
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }

        // 数组只有一个元素的时候
        if (nums.length == 1) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> item = new ArrayList<>();
            item.add(nums[0]);

            ans.add(item);
            return ans;
        }

        // 数组元素个数大于等于2的时候
        return recursivePermute(nums, 0);
    }

    /**
     * 获取从index开始后边所有数的全排列
     *
     * @param nums  给定数组
     * @param index 开始索引
     * @return
     */
    public List<List<Integer>> recursivePermute(int[] nums, int index) {
        List<List<Integer>> ans = new ArrayList<>();

        // 最后两个数的全排列
        if (nums.length - index == 2) {
            List<Integer> item1 = new ArrayList<>();
            item1.add(nums[index]);
            item1.add(nums[index + 1]);

            List<Integer> item2 = new ArrayList<>();
            item2.add(nums[index + 1]);
            item2.add(nums[index]);

            ans.add(item1);
            ans.add(item2);
        } else {
            // 获取index以后所有数的全排列
            List<List<Integer>> temp = recursivePermute(nums, index + 1);

            // 加上当前数（插入到所有排列的所有空隙）
            for (List<Integer> list : temp) {
                for (int i = 0; i <= list.size(); i++) {
                    List<Integer> item = new ArrayList<>(list);
                    item.add(i, nums[index]);
                    ans.add(item);
                }
            }
        }

        return ans;
    }

}
