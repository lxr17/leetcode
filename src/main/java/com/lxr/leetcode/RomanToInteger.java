package com.lxr.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * For example, two is written as II in Roman numeral, just two one's added together.
 * Twelve is written as, XII, which is simply X + II. The number twenty seven is
 * written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four. The same principle
 * applies to the number nine, which is written as IX.
 * <p>
 * eg.
 * Input: "III"
 * Output: 3
 * <p>
 * Input: "IV"
 * Output: 4
 * <p>
 * Input: "IX"
 * Output: 9
 * <p>
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * <p>
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class RomanToInteger {

    /**
     * 11ms      7.52% Run time
     * 37.4MB    54.52% Memory
     */
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        int sum = 0;

        char[] chars = s.toCharArray();

        // 单个字符遍历求和
        for (int i = 0; i < chars.length; ) {
            String chs;
            if (i + 1 < chars.length) {
                chs = chars[i] + "" + chars[i + 1];
            } else {
                chs = chars[i] + "";
            }

            if (map.get(chs) == null) {
                chs = chs.substring(0, 1);
            }

            sum = sum + map.get(chs);

            i = i + chs.length();
        }

        return sum;
    }

}
