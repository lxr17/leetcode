package com.lxr.leetcode;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 * <p>
 * e.g.
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * <p>
 * Note:
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class GroupAnagrams {

    /**
     * 6ms    99.49% Run time
     * 45.6MB 34.50% Memory
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String sortedStr = sort(str);
            List<String> value = map.get(sortedStr);

            if (value == null) {
                value = new ArrayList<>();
                map.put(sortedStr, value);
            }

            value.add(str);
        }

        return new ArrayList<>(map.values());
    }

    /**
     * 对字符串按照字符进行排序
     *
     * @param str 原始字符串
     * @return 排序完之后的字符串
     */
    private String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
