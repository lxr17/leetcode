package com.lxr.leetcode;

/**
 * Write a function to find the longest common prefix string
 * amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * eg.
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * Note:
 * All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {

    /**
     * 1ms      73.74% Run time
     * 37.7MB   83.49% Memory
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        int index = -1;
        while (true) {
            boolean isEqual = true;

            // 判断第 index + 1 位是否一致
            for (int i = 0; i < strs.length - 1; i++) {
                if (strs[i].length() < index + 2 || strs[i + 1].length() < index + 2) {
                    isEqual = false;
                    break;
                }

                if (strs[i].charAt(index + 1) != strs[i + 1].charAt(index + 1)) {
                    isEqual = false;
                }
            }

            // 如果一致，那索引加一
            if (isEqual) {
                index++;
            } else {
                break;
            }
        }

        return strs[0].substring(0, index + 1);
    }

}
