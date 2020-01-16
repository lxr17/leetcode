package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * eg.
 * Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class PermutationsII {

    /**
     * 23ms    15.65% Run time
     * 39.9MB  58.21% Memory
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }

        // 数组元素个数大于等于1的时候
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

        // 最后一个数的全排列
        if (nums.length - index == 1) {

            List<Integer> item = new ArrayList<>();
            item.add(nums[index]);

            ans.add(item);
        } else {
            // 获取index以后所有数的全排列
            List<List<Integer>> temp = recursivePermute(nums, index + 1);

            // 加上当前数（插入到所有排列的所有空隙，注意去重）
            for (List<Integer> list : temp) {
                for (int i = 0; i <= list.size(); i++) {
                    List<Integer> item = new ArrayList<>(list);
                    item.add(i, nums[index]);
                    if (!ans.contains(item)) {
                        ans.add(item);
                    }
                }
            }
        }

        return ans;
    }

}
