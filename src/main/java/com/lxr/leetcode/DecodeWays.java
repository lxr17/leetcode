package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * <p>
 * To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 * <p>
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
 * <p>
 * Given a string s containing only digits, return the number of ways to decode it.
 * <p>
 * The answer is guaranteed to fit in a 32-bit integer.
 * <p>
 * eg1.
 * Input: s = "12"
 * Output: 2
 * Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
 * <p>
 * eg2.
 * Input: s = "226"
 * Output: 3
 * Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * <p>
 * eg3.
 * Input: s = "0"
 * Output: 0
 * Explanation: There is no character that is mapped to a number starting with 0.
 * The only valid mappings with 0 are 'J' -> "10" and 'T' -> "20", neither of which start with 0.
 * Hence, there are no valid ways to decode this since all digits need to be mapped.
 * <p>
 * eg4.
 * Input: s = "06"
 * Output: 0
 * Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
 * <p>
 * Constraints:
 * 1 <= s.length <= 100
 * s contains only digits and may contain leading zero(s).
 */
public class DecodeWays {

    /**
     * 内存溢出了
     */
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();

        // 字符串开头是0的话，不可解码
        if (chars.length == 0 || chars[0] == '0') {
            return 0;
        }

        // 所有不同的情况（存储每种方法走到的索引值）
        List<Integer> ways = new ArrayList<>();
        boolean isOver = false;

        while (!isOver) {
            isOver = true;

            if (ways.size() == 0) {
                if (chars.length == 1) {
                    ways.add(0);
                } else if (chars.length >= 2) {
                    ways.add(0);

                    // 前两位
                    int preTwo = Integer.parseInt(new String(new char[]{chars[0], chars[1]}));
                    if (preTwo <= 26) {
                        ways.add(1);
                    }

                    isOver = false;
                }
            } else {
                List<Integer> newWays = new ArrayList<>();
                for (int i = 0; i < ways.size(); i++) {
                    int index = ways.get(i);

                    if (index == chars.length - 1) {// 该方法已经走到终点(证明该方法可行)
                        newWays.add(index);
                        continue;
                    } else if (index == chars.length - 2) {// 该方法走到了终点前一位
                        // 最后一位不是0这种方法才成立
                        if (chars[index + 1] != '0') {
                            newWays.add(index + 1);
                        }
                    } else {
                        if (chars[index + 1] != '0') {
                            newWays.add(index + 1);

                            // 后两位
                            int lastTwo = Integer.parseInt(new String(new char[]{chars[index + 1], chars[index + 2]}));
                            if (lastTwo <= 26) {
                                newWays.add(index + 2);
                            }

                            isOver = false;
                        }
                    }
                }

                ways.clear();
                ways.addAll(newWays);
            }
        }

        return ways.size();
    }

    /**
     * 7ms      8.08% Run time
     * 39.4MB   5.87% Memory
     */
    public int numDecodings2(String s) {
        char[] chars = s.toCharArray();

        // 字符串开头是0的话，不可解码
        if (chars.length == 0 || chars[0] == '0') {
            return 0;
        }

        // 所有不同的情况（key为走到的索引值，value为走到这儿一共有多少种方法）
        Map<Integer, Integer> ways = new HashMap<>();
        boolean isOver = false;

        while (!isOver) {
            isOver = true;

            if (ways.size() == 0) {
                if (chars.length == 1) {
                    ways.put(0, 1);
                } else if (chars.length >= 2) {
                    ways.put(0, 1);

                    // 前两位
                    int preTwo = Integer.parseInt(new String(new char[]{chars[0], chars[1]}));
                    if (preTwo <= 26) {
                        ways.put(1, 1);
                    }

                    isOver = false;
                }
            } else {
                Map<Integer, Integer> newWays = new HashMap<>();
                for (int index : ways.keySet()) {
                    int count = ways.get(index);

                    if (index == chars.length - 1) {// 该方法已经走到终点(证明该方法可行)
                        newWays.put(index, count + newWays.getOrDefault(index, 0));
                        continue;
                    } else if (index == chars.length - 2) {// 该方法走到了终点前一位
                        // 最后一位不是0这种方法才成立
                        if (chars[index + 1] != '0') {
                            newWays.put(index + 1, count + newWays.getOrDefault(index + 1, 0));
                        }
                    } else {
                        if (chars[index + 1] != '0') {
                            newWays.put(index + 1, count + newWays.getOrDefault(index + 1, 0));

                            // 后两位
                            int lastTwo = Integer.parseInt(new String(new char[]{chars[index + 1], chars[index + 2]}));
                            if (lastTwo <= 26) {
                                newWays.put(index + 2, count + newWays.getOrDefault(index + 2, 0));
                            }

                            isOver = false;
                        }
                    }
                }

                ways.clear();
                ways.putAll(newWays);
            }
        }

        if (ways.size() == 1) {
            return ways.get(chars.length - 1);
        }

        return 0;
    }

}
