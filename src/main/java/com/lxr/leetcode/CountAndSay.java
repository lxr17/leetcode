package com.lxr.leetcode;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * ```
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * ```
 * `1` is read off as `"one 1"` or `11`.
 * `11` is read off as `"two 1s"` or `21`.
 * `21` is read off as `"one 2, then one 1"` or `1211`.
 * <p>
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 * <p>
 * Note: Each term of the sequence of integers will be represented as a string.
 * <p>
 * eg1.
 * Input: 1
 * Output: "1"
 * <p>
 * eg2.
 * Input: 4
 * Output: "1211"
 */
public class CountAndSay {

    /**
     * 1ms     99.69% Run time
     * 34.1MB  100.00% Memory
     */
    public String countAndSay(int n) {
        if (n > 1) {
            // 获取n-1返回的值
            String lastAns = countAndSay(n - 1);

            StringBuilder ans = new StringBuilder();

            // 初始化两个局部变量
            char num = lastAns.charAt(0);
            int count = 0;

            // 遍历字符串，得到需要的字符串
            for (int i = 0; i < lastAns.length(); i++) {
                if (lastAns.charAt(i) != num) {
                    if (count > 0) {
                        ans.append((char) ('0' + count)).append(num);
                    }

                    num = lastAns.charAt(i);
                    count = 1;
                } else {
                    num = lastAns.charAt(i);
                    count++;
                }

                // 处理结束了的情况
                if (i == lastAns.length() - 1) {
                    ans.append((char) ('0' + count)).append(num);
                }
            }

            return ans.toString();
        } else {
            return "1";
        }
    }

}
