package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * eg1.
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * <p>
 * eg2.
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * <p>
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class MergeIntervals {

    /**
     * 6ms     57.53% Run time
     * 41.9MB  50.00% Memory
     */
    public int[][] merge(int[][] intervals) {
        List<int[]> data = new ArrayList<>();
        List<int[]> ans = new ArrayList<>();

        for (int[] temp : intervals) {
            data.add(temp);
        }

        // 正对于左进行排序
        Collections.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[0] - t2[0];
            }
        });

        // 合并
        for (int[] temp : data) {
            if (ans.size() == 0) {
                ans.add(temp);
            }

            int[] last = ans.get(ans.size() - 1);

            // 合并
            if (temp[0] <= last[1] && temp[1] >= last[1]) {
                last[1] = temp[1];
            }

            if (temp[0] > last[1]) {
                ans.add(temp);
            }
        }

        int[][] realAns = new int[ans.size()][];
        ans.toArray(realAns);
        return realAns;
    }

}
