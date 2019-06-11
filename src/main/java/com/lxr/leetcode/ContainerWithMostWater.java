package com.lxr.leetcode;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a
 * point at coordinate (i, ai). n vertical lines are drawn such that the two
 * endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
 * with x-axis forms a container, such that the container contains the most
 * water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 * <p>
 * eg.
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */
public class ContainerWithMostWater {

    /**
     * 207ms    15.11% Run time
     * 38.4MB   99.95 Memory
     */
    public int maxArea(int[] height) {
        int max = 0;

        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int temp = (j - i) * Math.min(height[i], height[j]);
                if (temp > max) {
                    max = temp;
                }
            }
        }

        return max;
    }

}
