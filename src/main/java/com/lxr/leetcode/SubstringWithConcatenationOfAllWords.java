package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given a string, s, and a list of words, words,
 * that are all of the same length. Find all starting indices of substring(s)
 * in s that is a concatenation of each word in words exactly once and
 * without any intervening characters.
 * <p>
 * eg1.
 * Input:
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * <p>
 * eg2.
 * Input:
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * Output: []
 */
public class SubstringWithConcatenationOfAllWords {

    /**
     * 298ms  9.95% Run time
     * 39.1MB 95.24% Memory
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ansList = new ArrayList<>();

        // 给定的words为空(或者s为空)
        if (words == null || words.length == 0 || s == null) {
            return ansList;
        }

        // s的总长度
        int sLength = s.length();

        // 单个word的长度
        int wLength = words[0].length();

        // words的总字符数
        int wsLength = wLength * words.length;

        // 如果s的长度不足words的总长度
        if (sLength < wsLength) {
            return ansList;
        }

        // 遍历所有可能的索引
        for (int i = 0; i <= sLength - wsLength; i++) {
            List<String> wList = new ArrayList<>(Arrays.asList(words));

            int index = i;

            // 判断此索引是否是所需要的
            while (wList.size() > 0) {
                String sub = s.substring(index, index + wLength);
                if (wList.contains(sub)) {
                    wList.remove(sub);
                    index += wLength;
                } else {
                    break;
                }
            }

            if (wList.size() == 0) {
                ansList.add(i);
            }
        }

        return ansList;
    }

}
