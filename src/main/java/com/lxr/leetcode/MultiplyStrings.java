package com.lxr.leetcode;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 * <p>
 * eg1.
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * <p>
 * eg2.
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * <p>
 * note:
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class MultiplyStrings {

    /**
     * 12ms 20.40% Run time
     * 37MB 100.00% Memory
     */
    public String multiply(String num1, String num2) {
        // 判断是否有0
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        // 构造一个数组用来存放最终结果
        int[] ans = new int[num1.length() + num2.length()];

        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                int num = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                insert(ans, num,
                        (num1.length() - 1 - i) + (num2.length() - 1 - j));
            }
        }

        // 输出
        StringBuilder sb = new StringBuilder();
        boolean start = false;
        for (int i = ans.length - 1; i >= 0; i--) {
            if (ans[i] == 0 && !start) {
                continue;
            } else {
                start = true;
                sb.append(Integer.toString(ans[i]));
            }
        }

        return sb.toString();
    }

    /**
     * 将数字插入数组
     *
     * @param ans   数组
     * @param num   单个数的乘积
     * @param zeros 0的个数
     */
    private void insert(int[] ans, int num, int zeros) {
        // 索引
        int index = zeros;

        // 进位
        int carry = 0;

        // 被加数
        char[] chs = Integer.toString(num).toCharArray();

        // 从后往前遍历相加
        for (int i = chs.length - 1; i >= 0; i--) {
            int indexNum = chs[i] - '0' + ans[index] + carry;

            carry = indexNum / 10;

            ans[index++] = indexNum % 10;
        }

        // 进位
        while (carry > 0) {
            int indexNum = ans[index] + carry;

            carry = indexNum / 10;

            ans[index++] = indexNum % 10;
        }
    }

}
