package com.lxr.leetcode;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.
 * <p>
 * eg1.
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * <p>
 * eg2.
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * <p>
 * Constraints:
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 */
public class MergeSortedArray {

    /**
     * 0ms     100.00% Run time
     * 39.1MB  54.08% Memory
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0) {
            return;
        }

        int[] temp = new int[nums1.length];

        int i = 0;// nums1当前索引
        int j = 0;// nums2当前索引
        int k = 0;// temp当前索引

        while (i < m || j < n) {
            if (i >= m) {
                temp[k] = nums2[j];
                j++;
                k++;
            } else if (j >= n) {
                temp[k] = nums1[i];
                i++;
                k++;
            } else if (nums1[i] < nums2[j]) {
                temp[k] = nums1[i];
                i++;
                k++;
            } else if (nums1[i] > nums2[j]) {
                temp[k] = nums2[j];
                j++;
                k++;
            } else {
                temp[k] = nums1[i];

                i++;
                k++;

                temp[k] = nums2[j];

                j++;
                k++;
            }
        }

        for (int t = 0; t < temp.length; t++) {
            nums1[t] = temp[t];
        }
    }

}
