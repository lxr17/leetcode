package com.lxr.leetcode;

import java.util.Arrays;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * <p>
 * eg1.
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class TrappingRainWater {

    /**
     * 1ms    94.66% Run time
     * 35.8MB 100.00% Memory
     */
    public int trap(int[] height) {
        // 思路：
        // 1. 找到最大值的索引
        // 2. 找到所有的顶点索引(顶点索引处的值比相邻两个数大，并且在最大值左边升序，在最大值右边降序)
        // 3. 计算水量

        // height的长度不足3构不成池子
        if (height.length <= 2) {
            return 0;
        }

        int maxIndex;// 最大值的索引
        int[] tops = new int[height.length];// 所有顶点索引
        Arrays.fill(tops, -1);

        // 找到最大值的索引(时间复杂度:O(n))
        maxIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] >= height[maxIndex]) {
                maxIndex = i;
            }
        }

        // 找到所有的顶点索引(时间复杂度:O(n))
        int leftIndex = -1;
        // 判断第一个数是不是顶点
        if (height[0] >= height[1]) {
            tops[++leftIndex] = 0;
        }
        // 索引<maxIndex的从左往右进行查找
        for (int i = 1; i < maxIndex; i++) {
            // 判断是不是顶点
            if (height[i] >= height[i - 1] && height[i] >= height[i + 1]) {
                // 第一个顶点
                if (leftIndex == -1) {
                    tops[++leftIndex] = i;
                    continue;
                }

                // 在最大值索引前的顶点，需升序；
                if (height[i] >= height[tops[leftIndex]]) {
                    tops[++leftIndex] = i;
                }
            }
        }

        int rightIndex = tops.length;
        // 判断最后一个点是不是顶点
        if (height[height.length - 1] >= height[height.length - 2]) {
            tops[--rightIndex] = height.length - 1;
        }
        // 索引>=maxIndex的从右往左进行查找
        for (int i = height.length - 2; i >= maxIndex; i--) {
            // 判断是不是顶点
            if ((i == 0 && height[i] >= height[i + 1])
                    || (height[i] >= height[i - 1] && height[i] >= height[i + 1])) {
                // 从右往左第一个顶点
                if (rightIndex == tops.length) {
                    tops[--rightIndex] = i;
                    continue;
                }

                // 在最大值索引后的顶点，需从右往左升序；
                if (height[i] >= height[tops[rightIndex]]) {
                    tops[--rightIndex] = i;
                }
            }
        }

        System.arraycopy(tops, rightIndex, tops, leftIndex + 1,
                tops.length - rightIndex);

        // 计算水量(时间复杂度:O(n))
        int index = 0;
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            if (i < tops[index]) {
                // 为了方便理解，所以就写了这行代码
                continue;
            } else if (i >= tops[index] && i < tops[index + 1]) {
                int min = height[tops[index]];
                if (height[tops[index]] > height[tops[index + 1]]) {
                    min = height[tops[index + 1]];
                }

                if (min > height[i]) {
                    sum += min - height[i];
                }
            } else if (i == tops[index + 1]) {
                index++;
            }
        }

        return sum;
    }

}
