package com.lxr.leetcode;

/**
 * Given an array of integers `nums` sorted in ascending order,
 * find the starting and ending position of a given `target` value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return `[-1, -1]`.
 * <p>
 * eg1.
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * <p>
 * eg2.
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * 0ms     100.00% Run time
     * 43.4 MB 97.16% Memory
     */
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};

        // 处理空数组的情况
        if (nums == null || nums.length == 0) {
            return ans;
        }

        // 处理长度为1的情况
        if (nums.length == 1) {
            if (nums[0] == target) {
                ans[0] = 0;
                ans[1] = 0;
            }

            return ans;
        }

        int left = 0;
        int right = nums.length - 1;

        int l1 = -1, r1 = -1, l2 = -1, r2 = -1;

        // 找到target所在的范围(时间复杂度：logn)
        while (true) {

            // 如果范围内只有两个数，则结果已出
            if (right - left == 1) {
                if (nums[left] == target && nums[right] == target) {
                    ans[0] = left;
                    ans[1] = right;
                } else if (nums[left] != target && nums[right] == target) {
                    ans[0] = right;
                    ans[1] = right;
                } else if (nums[left] == target && nums[right] != target) {
                    ans[0] = left;
                    ans[1] = left;
                }

                return ans;
            }

            int middle = (left + right) / 2;

            // 切掉一半
            if (nums[middle] > target) {
                right = middle;
                continue;
            }

            // 切掉一半
            if (nums[middle] < target) {
                left = middle;
                continue;
            }

            // 此时`nums[middle] == target`
            l1 = left;
            r1 = middle;
            l2 = middle;
            r2 = right;
            break;
        }

        // 此时证明nums中有target值
        if (l1 != -1) {
            // 找从左往右的第一个target值(时间复杂度logn)
            while (true) {
                if (r1 - l1 == 1) {
                    if (nums[l1] == target) {
                        ans[0] = l1;
                    } else if (nums[r1] == target) {
                        ans[0] = r1;
                    }
                    break;
                }

                int m1 = (l1 + r1) / 2;
                if (nums[m1] == target) {
                    r1 = m1;
                } else {
                    l1 = m1;
                }
            }

            // 找从右往左的第一个target值(时间复杂度logn)
            while (true) {
                if (r2 - l2 == 1) {
                    if (nums[r2] == target) {
                        ans[1] = r2;
                    } else if (nums[l2] == target) {
                        ans[1] = l2;
                    }
                    break;
                }

                int m2 = (l2 + r2) / 2;
                if (nums[m2] == target) {
                    l2 = m2;
                } else {
                    r2 = m2;
                }
            }
        }

        return ans;
    }

}
