package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * <p>
 * eg1.
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * <p>
 * eg2.
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
public class CombinationSumII {

    /**
     * 2ms    100.00% Run time
     * 36.3MB 100.00% Memory
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        return recursive(candidates, target, 0);
    }

    /**
     * 从startIndex索引起在candidates中选若干个求和等于target的结果集
     *
     * @param candidates 候选数
     * @param target     目标数
     * @param startIndex 开始索引
     * @return
     */
    private List<List<Integer>> recursive(int[] candidates, int target, int startIndex) {
        List<List<Integer>> ans = new ArrayList<>();

        // 此时无满足条件的结果集
        if (startIndex >= candidates.length || target < candidates[startIndex]) {
            return ans;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            int thisNum = candidates[i];

            // 防止重复答案
            if (i > startIndex && thisNum == candidates[i - 1]) {
                continue;
            }

            // 此时已经找到目标值
            if (target == thisNum) {
                List<Integer> item = new ArrayList<>();
                item.add(target);
                ans.add(item);
                return ans;
            }

            // 继续迭代找结果集
            List<List<Integer>> temp = recursive(candidates, target - thisNum, i + 1);

            for (List<Integer> item : temp) {
                item.add(0, thisNum);
                ans.add(item);
            }
        }

        return ans;
    }

}
