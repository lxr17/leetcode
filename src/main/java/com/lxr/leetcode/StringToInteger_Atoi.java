package com.lxr.leetcode;

/**
 * Implement atoi which converts a string to an integer.
 * <p>
 * The function first discards as many whitespace characters as necessary
 * until the first non-whitespace character is found. Then, starting from
 * this character, takes an optional initial plus or minus sign followed by as
 * many numerical digits as possible, and interprets them as a numerical value.
 * <p>
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of
 * this function.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is
 * empty or it contains only whitespace characters, no conversion is performed.
 * <p>
 * If no valid conversion could be performed, a zero value is returned.
 * <p>
 * Note:
 * Only the space character ' ' is considered as whitespace character.
 * <p>
 * Assume we are dealing with an environment which could only
 * store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * If the numerical value is out of the range of representable values,
 * INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * <p>
 * eg.
 * Input: "42"
 * Output: 42
 * <p>
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 * Then take as many numerical digits as possible, which gets 42.
 * <p>
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next
 * character is not a numerical digit.
 * <p>
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 * <p>
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 * Therefore INT_MIN (−231) is returned.
 */
public class StringToInteger_Atoi {

    /**
     * 3ms     62.44% Run time
     * 35.3 MB 99.97% Memory
     */
    public int myAtoi(String str) {
        // empty
        if (str == null || str.length() == 0 || str.trim().length() == 0) {
            return 0;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : str.trim().toCharArray()) {
            if (stringBuilder.length() == 0 && (ch == '+' || ch == '-')) {
                stringBuilder.append(ch);
                continue;
            }

            if (Character.isDigit(ch)) {
                stringBuilder.append(ch);
            } else {
                break;
            }
        }

        // if empty
        if (stringBuilder.length() == 0) {
            return 0;
        }

        // if -
        if ("-".equals(stringBuilder.toString()) || "+".equals(stringBuilder.toString())) {
            return 0;
        }

        try {
            return Integer.parseInt(stringBuilder.toString());
        } catch (NumberFormatException ex) {
            if (stringBuilder.toString().startsWith("-")) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

}
