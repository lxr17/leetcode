package com.lxr.leetcode;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * <p>
 * eg.
 * Input: [2,1,5,6,2,3]
 * Output: 10
 */
public class LargestRectangleInHistogram {

    /**
     * 811ms    9.55% Run time
     * 41.4MB   42.75% Memory
     */
    public int largestRectangleArea(int[] heights) {
        // 最大面积
        int maxArea = 0;

        // 最小值
        int minValue;

        for (int i = 0; i < heights.length; i++) {
            minValue = heights[i];

            // [i, j]区间面积最大值
            for (int j = i; j < heights.length; j++) {
                // 重新判断最小值
                if (heights[j] < minValue) {
                    minValue = heights[j];
                }

                // [i, j]区间的面积
                int area = minValue * (j - i + 1);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }

}
