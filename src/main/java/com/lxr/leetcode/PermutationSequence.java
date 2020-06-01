package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * <p>
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * <p>
 * Note:
 * <p>
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * <p>
 * eg1.
 * Input: n = 3, k = 3
 * Output: "213"
 * <p>
 * eg2.
 * Input: n = 4, k = 9
 * Output: "2314"
 */
public class PermutationSequence {

    /**
     * 1ms     98.49% Run time
     * 37.1MB  20.83% Memory
     */
    public String getPermutation(int n, int k) {
        // 所有的元数字
        List<Integer> candidate = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            candidate.add(i);
        }

        // 结果
        StringBuilder builder = new StringBuilder();

        // 从左到右一个数字一个数字的找
        while (candidate.size() > 1) {
            int temp = factorial(n - 1 - builder.length());

            int index = k / temp - ((k % temp) == 0 ? 1 : 0);
            builder.append(candidate.get(index));
            candidate.remove(index);

            k = k - temp * index;
        }

        builder.append(candidate.get(0));

        return builder.toString();
    }

    /**
     * 计算n!
     */
    private int factorial(int n) {
        int ans = 1;
        for (int i = 2; i <= n; i++) {
            ans = ans * i;
        }

        return ans;
    }

}
