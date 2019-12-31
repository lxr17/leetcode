package com.lxr.leetcode;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 * <p>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 * <p>
 * eg1.
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * <p>
 * eg2.
 * Input:
 * s = "aa"
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * <p>
 * eg3.
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 * <p>
 * eg4.
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 * <p>
 * eg5.
 * Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 */
public class WildcardMatching {

    /**
     * 6ms     77.47% Run time
     * 38.3MB  93.02% Memory
     */
    public boolean isMatch(String s, String p) {
        if (p.equals(s)) {
            return true;
        }

        // 此时 s.length() > 0
        if (p.length() == 0) {
            return false;
        }

        // 1.拆分匹配规则
        // 2.分段匹配

        // 拆分匹配规则
        String[] pArray = p.split("\\*");

        int firstMatchIndex = s.length();
        int lastMatchIndex = -1;

        int[] match;

        // 开始索引
        int startIndex = 0;

        // 分段匹配
        for (int i = 0; i < pArray.length; i++) {
            String segment = pArray[i];
            if (segment.length() == 0) {
                continue;
            }

            // 分段匹配
            if (pArray.length == 1 && p.charAt(p.length() - 1) == '*') {// 针对于只有一段的情况
                match = findMatchIndex(s, segment, startIndex);
            } else if (i == pArray.length - 1) {// 最后一段(有多段的情况下的最后一段)
                match = findLastMatchIndex(s, segment, startIndex);
            } else {// 其他段
                match = findMatchIndex(s, segment, startIndex);
            }

            if (match[0] <= firstMatchIndex) {
                firstMatchIndex = match[0];
            }

            if (match[1] - 1 >= lastMatchIndex) {
                lastMatchIndex = match[1] - 1;
            }

            startIndex = match[1];
            if (-1 == startIndex) {
                return false;
            }
        }

        // 只要走到这儿，就说明所有的分段都匹配成功了
        // 正则的首部匹配
        // 正则的尾部匹配
        return (p.charAt(0) == '*' || firstMatchIndex == 0)
                && (p.charAt(p.length() - 1) == '*' || lastMatchIndex == s.length() - 1);
    }

    /**
     * 找到匹配部分索引，从前往后匹配
     *
     * @param s          原始字符串
     * @param p          匹配规则
     * @param startIndex 开始索引
     * @return 部分匹配成功之后，返回匹配的一个区间(左闭右开)，其中-1表示未匹配成功
     */
    public int[] findMatchIndex(String s, String p, int startIndex) {
        int[] match = new int[]{-1, -1};

        if (startIndex >= s.length()) {
            return match;
        }

        // 记录p的索引
        int pIndex = 0;
        // 记录s的索引
        int sIndex = startIndex++;

        // 注意 p.length() > s.length() 的情况
        while (pIndex < p.length() && sIndex < s.length()) {
            boolean isMatch = p.charAt(pIndex) == '?' || s.charAt(sIndex) == p.charAt(pIndex);
            if (isMatch) {// 匹配成功
                if (pIndex == p.length() - 1) {// 最后一位
                    match[0] = startIndex - 1;
                    match[1] = sIndex + 1;
                    return match;
                }

                ++sIndex;
                ++pIndex;
            } else if (startIndex < s.length() - p.length() + 1) {// 下一个候选人
                sIndex = startIndex++;
                pIndex = 0;
            } else {
                return match;
            }
        }

        return match;
    }

    /**
     * 找到匹配部分索引，从后往前匹配
     * 针对于 s="aaaa", p="***a" 的例子特地增加此方法
     *
     * @param s          原始字符串
     * @param p          匹配规则
     * @param startIndex 开始索引
     * @return 部分匹配成功之后，返回匹配的一个区间(左闭右开)，其中-1表示未匹配成功
     */
    public int[] findLastMatchIndex(String s, String p, int startIndex) {
        int[] match = new int[]{-1, -1};

        if (startIndex >= s.length()) {
            return match;
        }

        // 从后往前匹配的开始索引
        int endIndex = s.length() - 1;
        // 记录p的索引
        int pIndex = p.length() - 1;
        // 记录s的索引
        int sIndex = endIndex--;

        while (pIndex >= 0 && sIndex >= startIndex) {
            boolean isMatch = p.charAt(pIndex) == '?' || s.charAt(sIndex) == p.charAt(pIndex);
            if (isMatch) {// 匹配成功
                if (pIndex == 0) {// 最后一位
                    match[0] = sIndex;
                    match[1] = sIndex + p.length();
                    return match;
                }

                --sIndex;
                --pIndex;
            } else if (endIndex - startIndex >= p.length() - 1) {// 下一个候选人
                sIndex = endIndex--;
                pIndex = p.length() - 1;
            } else {
                return match;
            }
        }

        return match;
    }

}
