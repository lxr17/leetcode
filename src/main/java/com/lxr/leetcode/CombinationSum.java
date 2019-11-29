package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * <p>
 * eg1.
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 * <p>
 * eg2.
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 */
public class CombinationSum {

    /**
     * 4ms    66.65% Run time
     * 40.1MB 10.37% Memory
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        boolean hasAns = false;

        // 只选一个数的答案
        for (int i = 0; i < candidates.length; i++) {
            if (target > candidates[i]) {
                hasAns = true;
            } else if (target == candidates[i]) {
                List<Integer> temp = new ArrayList<>();
                temp.add(target);
                ans.add(temp);
            }
        }

        // 如果候选人中所有的数字都比target大
        if (!hasAns) {
            return ans;
        }

        for (int i = 0; i < candidates.length; i++) {
            int[] rest = Arrays.copyOfRange(candidates, i, candidates.length);
            List<List<Integer>> temp = combinationSum(rest, target - candidates[i]);

            for (List<Integer> list : temp) {
                list.add(0, candidates[i]);
                ans.add(list);
            }
        }

        return ans;
    }

}
