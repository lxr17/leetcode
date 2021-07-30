package com.lxr.leetcode;

import java.util.Stack;

/**
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 * <p>
 * An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 * Note: a + b is the concatenation of strings a and b.
 * <p>
 * eg1.
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * <p>
 * eg2.
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 * <p>
 * eg3.
 * Input: s1 = "", s2 = "", s3 = ""
 * Output: true
 * <p>
 * Constraints:
 * 0 <= s1.length, s2.length <= 100
 * 0 <= s3.length <= 200
 * s1, s2, and s3 consist of lowercase English letters.
 * <p>
 * Follow up: Could you solve it using only O(s2.length) additional memory space?
 */
public class InterleavingString {

    /**
     * Time Limit Exceeded 了
     * s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa"
     * s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab"
     * s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // 长度不相等，必定不匹配
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        // 一种简单的匹配
        if (s1.length() == 0) {
            return s2.equals(s3);
        }
        if (s2.length() == 0) {
            return s1.equals(s3);
        }

        int curPosS1 = 0;
        int curPosS2 = 0;
        int curPosS3 = 0;

        // s3 的拆分子串
        Stack<String> subs = new Stack<>();

        // s3 的开头是否和 s1 的开头匹配（优先匹配 s1 的开头，无法匹配再匹配 s2 的开头）
        boolean isMatchS1Head = true;

        // 当前匹配的是否为 s1
        boolean matchS1 = true;

        // 1. 将 s3 与 s1 或者 s2 从 curPos 开始比较，尽可能多的匹配，并分割
        // 2. 分割后与另一个字符串比较
        // 3. 如果可以继续分割，则重复 1 和 2
        // 4. 如果不可以继续分割，则前一个拆分子串长度减一，并重复 1 和 2
        while (true) {
            int subStrLength = 1;

            // 匹配子串
            if (matchS1) {
                while (curPosS1 + subStrLength - 1 < s1.length() && s1.charAt(curPosS1 + subStrLength - 1) == s3.charAt(curPosS3 + subStrLength - 1)) {
                    subStrLength++;
                }
            } else {
                while (curPosS2 + subStrLength - 1 < s2.length() && s2.charAt(curPosS2 + subStrLength - 1) == s3.charAt(curPosS3 + subStrLength - 1)) {
                    subStrLength++;
                }
            }

            if (subStrLength - 1 > 0) {// 匹配到了
                // 匹配完了
                if (curPosS3 + subStrLength - 1 == s3.length()) {
                    return true;
                }

                // 子串入栈
                String subStr = s3.substring(curPosS3, curPosS3 + subStrLength - 1);
                subs.push(subStr);

                // 索引增加
                if (matchS1) {
                    curPosS1 += subStrLength - 1;
                } else {
                    curPosS2 += subStrLength - 1;
                }
                curPosS3 += subStrLength - 1;

                // 换另一个子串进行匹配
                matchS1 = !matchS1;
            } else { // 未匹配到
                // 开始回溯
                if (!subs.empty()) {
                    while (!subs.empty()) {
                        String top = subs.pop();

                        if (top.length() > 1) {
                            if (matchS1) {
                                curPosS2 -= 1;
                            } else {
                                curPosS1 -= 1;
                            }

                            curPosS3 -= 1;
                            subs.push(top.substring(0, top.length() - 1));

                            break;
                        } else {
                            if (matchS1) {
                                curPosS2 -= 1;
                            } else {
                                curPosS1 -= 1;
                            }

                            curPosS3 -= 1;
                            matchS1 = !matchS1;
                        }
                    }
                }

                // 回溯失败
                if (subs.empty()) {
                    if (isMatchS1Head) {
                        isMatchS1Head = false;
                        matchS1 = false;
                    } else {
                        return false;
                    }
                }
            }
        }
    }

    /**
     * 7ms      30.06% Run time
     * 37.3MB   72.33% Memory
     * 思路：动态规划
     */
    public boolean isInterleave2(String s1, String s2, String s3) {
        // 长度不相等，必定不匹配
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        // 一种简单的匹配
        if (s1.length() == 0) {
            return s2.equals(s3);
        }
        if (s2.length() == 0) {
            return s1.equals(s3);
        }

        // 记 s[i] 表示 s 字符串的 s[0, i) 子串
        // dp[i][j] 代表 s1[i] 与 s2[j] 能否交叉匹配到 s3[i + j]
        // 1  1  1  1  1  1  1  1
        // 1  1  1  1  1  1  1  1
        // 1  1  1  1  1  1  1  1
        // 1  1  1  1  1  1  1  1
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        // 主要思路
        // 1. 如果 s1[i] 的末尾字符等于 s3[i + j] 的末尾字符，则只需要知道 s1[i - 1] 与 s2[j] 是否能交叉匹配即可
        // 2. 如果 s2[j] 的末尾字符等于 s3[i + j] 的末尾字符，则只需要知道 s1[i] 与 s2[j - 1] 是否交叉匹配即可
        // 3. 如果 s3[i + j] 的末尾字符和 s1[i] 的末尾字符、 s2[j] 的末尾字符都不匹配，则 dp[i][j] = false
        // 4. 如果 1. 或 2. 成立，则 dp[i][j] = true ，否则 false
        // 5. 边界条件为 dp[1][0] 和 dp[0][1]
        dp[0][0] = true;
        for (int i = 0; i < s1.length() + 1; i++) {
            for (int j = 0; j < s2.length() + 1; j++) {
                // 条件1
                if (i > 0 && s3.charAt(i + j - 1) == s1.charAt(i - 1) && dp[i - 1][j]) {
                    dp[i][j] = true;
                }

                // 条件2
                if (j > 0 && s3.charAt(i + j - 1) == s2.charAt(j - 1) && dp[i][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
