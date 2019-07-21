package com.lxr.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X,
 * L, C, D and M.
 * <p>
 * For example, two is written as II in Roman numeral, just two one's
 * added together. Twelve is written as, XII, which is simply X + II.
 * The number twenty seven is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four
 * is written as IV. Because the one is before the five we subtract it
 * making four. The same principle applies to the number nine,
 * which is written as IX. There are six instances where subtraction is used:
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * <p>
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * eg.
 * Input: 3
 * Output: "III"
 * <p>
 * Input: 4
 * Output: "IV"
 * <p>
 * Input: 9
 * Output: "IX"
 * <p>
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * <p>
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class IntegerToRoman {

    /**
     * 7ms      15.99% Run time
     * 39.4MB   14.43% Memory
     */
    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");

        StringBuilder stringBuilder = new StringBuilder();

        int digit = 1;
        while (num > 0) {
            int lastNum = num % 10;
            stringBuilder.insert(0, intToRomanForDigit(lastNum, digit, map));

            num = num / 10;
            digit = digit * 10;
        }

        return stringBuilder.toString();
    }

    private String intToRomanForDigit(int num, int digit, Map<Integer, String> source) {
        StringBuilder stringBuilder = new StringBuilder();

        if (9 == num) {// 9特殊处理
            stringBuilder.append(source.get(1 * digit)).append(source.get(10 * digit));
        } else if (4 == num) {// 4特殊处理
            stringBuilder.append(source.get(1 * digit)).append(source.get(5 * digit));
        } else {
            // 大于5
            if (num - 5 >= 0) {
                stringBuilder.append(source.get(5 * digit));
            }

            // 小于5的部分
            int ext = num % 5;
            while (ext > 0) {
                stringBuilder.append(source.get(digit));
                ext--;
            }
        }

        return stringBuilder.toString();
    }

}
