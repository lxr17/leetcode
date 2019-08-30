package com.lxr.leetcode;

import java.util.*;

/**
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 * <p>
 * eg.
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * Note:
 * Although the above answer is in lexicographical order,
 * your answer could be in any order you want.
 */
public class LetterCombinationsOfAPhoneNumber {

    private static Map<Character, List<Character>> match = new HashMap<>();

    static {
        match.put('2', Arrays.asList(new Character[]{'a', 'b', 'c'}));
        match.put('3', Arrays.asList(new Character[]{'d', 'e', 'f'}));
        match.put('4', Arrays.asList(new Character[]{'g', 'h', 'i'}));
        match.put('5', Arrays.asList(new Character[]{'j', 'k', 'l'}));
        match.put('6', Arrays.asList(new Character[]{'m', 'n', 'o'}));
        match.put('7', Arrays.asList(new Character[]{'p', 'q', 'r', 's'}));
        match.put('8', Arrays.asList(new Character[]{'t', 'u', 'v'}));
        match.put('9', Arrays.asList(new Character[]{'w', 'x', 'y', 'z'}));
    }

    /**
     * 1ms      64.55% Run time
     * 36.2MB   98.63% Memory
     */
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        List<StringBuilder> list = getSubString(digits);
        for (StringBuilder sb : list) {
            ans.add(sb.toString());
        }

        return ans;
    }

    public List<StringBuilder> getSubString(String digits) {
        List<StringBuilder> list = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return list;
        }

        char[] chars = digits.toCharArray();

        if (chars.length == 1) {
            for (char ch : match.get(chars[0])) {
                list.add(new StringBuilder().append(ch));
            }

        } else {
            // 获取索引1及以后的所有子串
            List<StringBuilder> subList = getSubString(digits.substring(1));
            for (char ch : match.get(chars[0])) {
                for (StringBuilder sb : subList) {
                    list.add(new StringBuilder(sb).insert(0, ch));
                }
            }
        }

        return list;
    }

}
