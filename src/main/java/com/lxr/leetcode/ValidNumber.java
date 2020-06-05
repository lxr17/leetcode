package com.lxr.leetcode;

/**
 * Validate if a given string can be interpreted as a decimal number.
 * <p>
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 * <p>
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:
 * <p>
 * Numbers 0-9
 * Exponent - "e"
 * Positive/negative sign - "+"/"-"
 * Decimal point - "."
 * Of course, the context of these characters also matters in the input.
 */
public class ValidNumber {

    /**
     * 3ms     39.99% Run time
     * 39.6MB  54.66% Memory
     */
    public boolean isNumber(String s) {
        // 去除左右的空格
        s = s.trim();

        // 空判断
        if (s.length() == 0) {
            return false;
        }

        // e在开头或者结尾都不是数字
        if (s.charAt(0) == 'e' || s.charAt(s.length() - 1) == 'e') {
            return false;
        }

        // 判断字符是否满足条件
        for (char ch : s.toCharArray()) {
            boolean isMatter = (ch >= '0' && ch <= '9') || ch == '+' || ch == '-' || ch == 'e' || ch == '.';
            if (!isMatter) {
                return false;
            }
        }

        String[] splits = s.split("e");

        // 此时不止一个e
        if (splits.length > 2) {
            return false;
        } else if (splits.length == 2) {
            // split[1]必须为整数，split[0]必须为数字
            if (getType(splits[0]) != 0 && getType(splits[1]) == 1) {
                return true;
            } else {
                return false;
            }
        } else {
            if (getType(splits[0]) != 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 判断s的类型
     * 注意：.1 和 1. 都算小数，但是 . 不是小数
     *
     * @param s
     * @return 0:非数字; 1:整数; 2:小数
     */
    private int getType(String s) {
        if (s.length() == 0) {
            return 0;
        }

        // 是否包含数字
        boolean containDigit = false;

        // 小数点的索引
        int pointIndex = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // 判断正负号
            if (ch == '+' || ch == '-') {
                // 当存在正负号不在首位时，s必定非数字
                if (i > 0) {
                    return 0;
                }
            }

            // 判断小数点
            if (ch == '.') {
                // 此时有复数个小数点
                if (pointIndex >= 0) {
                    return 0;
                } else {
                    pointIndex = i;
                }
            }

            // 是否包含数字
            if (!containDigit && ch >= '0' && ch <= '9') {
                containDigit = true;
            }
        }

        if (!containDigit) {
            return 0;
        }

        if (pointIndex == -1) {
            return 1;
        } else {
            return 2;
        }
    }

}
