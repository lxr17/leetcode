package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * eg1.
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * <p>
 * eg2.
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * <p>
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class InsertInterval {

    /**
     * 1ms      98.49% Run time
     * 41.4MB   75.00% Memory
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();

        Integer left = null;// 区间左
        Integer right = null;// 区间右
        boolean isFind = false;// 是否找到合并后的区间

        // 遍历每个区间，找到newInterval的区间范围
        for (int[] temp : intervals) {
            // 还未找到左，开始找左
            if (left == null) {
                // 判断newInterval[0]的位置
                if (newInterval[0] < temp[0]) {
                    left = newInterval[0];
                } else if (newInterval[0] >= temp[0] && newInterval[0] <= temp[1]) {
                    left = temp[0];
                } else {
                    ans.add(temp);
                }
            }

            // 已经找到左了，开始找右
            if (left != null && !isFind) {
                // 判断newInterval[1]的位置
                if (newInterval[1] > temp[1]) {
                    right = newInterval[1];
                } else if (newInterval[1] >= temp[0] && newInterval[1] <= temp[1]) {
                    right = temp[1];
                    // 此时的右是事实上的右，因此可添加进ans
                    ans.add(new int[]{left, right});

                    isFind = true;
                    continue;
                } else {
                    right = newInterval[1];

                    // 此时整个新区间都在最左边
                    ans.add(new int[]{left, right});
                    ans.add(temp);

                    isFind = true;
                    continue;
                }
            }

            // 左右都找到了，但是右有可能扩展
            if (left != null && right != null) {
                if (isFind) {
                    ans.add(temp);
                } else {
                    if (right < temp[0]) {
                        ans.add(new int[]{left, right});
                        isFind = true;

                        // 再加上本区间
                        ans.add(temp);
                    } else if (right >= temp[0] && right <= temp[1]) {
                        right = temp[1];
                        ans.add(new int[]{left, right});
                        isFind = true;
                    }
                }
            }
        }

        if (!isFind) {
            // 防止出现找了一圈没找到的情况
            if (left == null && newInterval.length > 0) {
                ans.add(newInterval);
            } else if (left != null) {
                ans.add(new int[]{left, right});
            }
            isFind = true;
        }

        int[][] realAns = new int[ans.size()][];
        ans.toArray(realAns);

        return realAns;
    }

}
