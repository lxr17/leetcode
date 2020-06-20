package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * eg.
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Combinations {

    /**
     * 5ms     84.37% Run time
     * 41.3MB  26.57% Memory
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        // 首先约定每一种可能都是后一个数比前一个数大
        // 然后一个数一个数的塞就行
        // 首先塞第一个数
        for (int i = 1; i <= n - k + 1; i++) {
            List<Integer> item = new ArrayList<>();
            item.add(i);

            ans.add(item);
        }

        // 然后塞其余的数
        for (int i = 2; i <= k; i++) {
            // 中间变量
            List<List<Integer>> temp = new ArrayList<>();

            // 取第i个数
            for (List<Integer> item : ans) {
                int lastNum = item.get(item.size() - 1);

                // 这里j的范围很重要
                for (int j = lastNum + 1; j <= n - k + i; j++) {
                    List<Integer> tempItem = new ArrayList<>(item);
                    tempItem.add(j);

                    temp.add(tempItem);
                }
            }

            ans.clear();
            ans.addAll(temp);
        }

        return ans;
    }

}
