package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An n-bit gray code sequence is a sequence of 2n integers where:
 * Every integer is in the inclusive range [0, 2n - 1],
 * The first integer is 0,
 * An integer appears no more than once in the sequence,
 * The binary representation of every pair of adjacent integers differs by exactly one bit, and
 * The binary representation of the first and last integers differs by exactly one bit.
 * <p>
 * Given an integer n, return any valid n-bit gray code sequence.
 * <p>
 * eg1.
 * Input: n = 2
 * Output: [0,1,3,2]
 * Explanation:
 * The binary representation of [0,1,3,2] is [00,01,11,10].
 * - 00 and 01 differ by one bit
 * - 01 and 11 differ by one bit
 * - 11 and 10 differ by one bit
 * - 10 and 00 differ by one bit
 * [0,2,3,1] is also a valid gray code sequence, whose binary representation is [00,10,11,01].
 * - 00 and 10 differ by one bit
 * - 10 and 11 differ by one bit
 * - 11 and 01 differ by one bit
 * - 01 and 00 differ by one bit
 * <p>
 * eg2.
 * Input: n = 1
 * Output: [0,1]
 * <p>
 * Constraints:
 * 1 <= n <= 16
 */
public class GrayCode {

    /**
     * 30ms     17.98% Run time
     * 62.8MB   5.47% Memory
     */
    public List<Integer> grayCode(int n) {
        // 最终结果
        List<Integer> ans = new ArrayList<>();

        // 缓存
        Map<Integer, Object> cache = new HashMap<>();
        Object placeHolder = new Object();

        // 是否继续寻找
        boolean canContinue = true;

        ans.add(0);
        cache.put(0, placeHolder);

        // 不停的找下一个数
        while (canContinue) {
            canContinue = false;
            int last = ans.get(ans.size() - 1);

            // 更改其中的一位，并判断在前面的序列是否存在这个数，不存在继续找
            for (int offset = 0; offset < n; offset++) {
                int temp = last ^ (1 << offset);
                if (cache.get(temp) == null) {
                    ans.add(temp);
                    cache.put(temp, placeHolder);
                    canContinue = true;
                    break;
                }
            }
        }

        return ans;
    }

}
