package com.lxr.leetcode;

/**
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * The input strings are both non-empty and contains only characters 1 or 0.
 * <p>
 * eg1.
 * Input: a = "11", b = "1"
 * Output: "100"
 * <p>
 * eg2.
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * <p>
 * Constraints:
 * Each string consists only of '0' or '1' characters.
 * 1 <= a.length, b.length <= 10^4
 * Each string is either "0" or doesn't contain any leading zero.
 */
public class AddBinary {

    /**
     * 2ms     76.04% Run time
     * 39.1MB  52.79% Memory
     */
    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();

        // 进位
        int carry = 0;
        // 从后往前索引
        int index = 0;

        // a和b在索引处的值
        int aSingle = 0;
        int bSingle = 0;

        int aLength = a.length();
        int bLength = b.length();

        while (carry > 0 || aLength - 1 - index >= 0 || bLength - 1 - index >= 0) {
            if (aLength - 1 - index >= 0) {
                aSingle = parse(a.charAt(aLength - 1 - index));
            } else {
                aSingle = 0;
            }

            if (bLength - 1 - index >= 0) {
                bSingle = parse(b.charAt(bLength - 1 - index));
            } else {
                bSingle = 0;
            }

            // 相加
            int temp = aSingle + bSingle + carry;
            carry = temp / 2;
            stringBuilder.insert(0, temp % 2);

            index++;
        }

        return stringBuilder.toString();
    }

    /**
     * 将单个字符转成数字
     *
     * @param ch
     * @return
     */
    public int parse(char ch) {
        return ch == '1' ? 1 : 0;
    }

}
