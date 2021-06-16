package com.lxr.leetcode;

import java.util.*;

/**
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * eg1.
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 * eg2.
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 * Constraints:
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 */
public class SubsetsII {

    /**
     * 11ms    6.37% Run time
     * 39.1MB  64.21% Memory
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        int length = nums.length;

        // 用作匹配，方便查询
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("null", new ArrayList<>());

        // 每次往已经找到的集合中添加当前元素
        for (int i = 0; i < length; i++) {
            int cur = nums[i];

            // 已有结果（key集）
            Set<String> keys = new HashSet<>(map.keySet());

            for (String key : keys) {
                String newKey = key + "," + cur;
                if (map.get(newKey) == null) {
                    List<Integer> item = new ArrayList<>(map.get(key));
                    item.add(cur);
                    map.put(newKey, item);
                }
            }
        }

        return new ArrayList<>(map.values());
    }

}
