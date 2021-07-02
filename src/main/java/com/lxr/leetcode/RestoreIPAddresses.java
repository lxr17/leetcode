package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s containing only digits, return all possible valid IP addresses that can be obtained from s. You can return them in any order.
 * <p>
 * A valid IP address consists of exactly four integers, each integer is between 0 and 255, separated by single dots and cannot have leading zeros. For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 * <p>
 * eg1.
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 * <p>
 * eg2.
 * Input: s = "0000"
 * Output: ["0.0.0.0"]
 * <p>
 * eg3.
 * Input: s = "1111"
 * Output: ["1.1.1.1"]
 * <p>
 * eg4.
 * Input: s = "010010"
 * Output: ["0.10.0.10","0.100.1.0"]
 * <p>
 * eg5.
 * Input: s = "101023"
 * Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * <p>
 * Constraints:
 * 0 <= s.length <= 3000
 * s consists of digits only.
 */
public class RestoreIPAddresses {

    /**
     * 7ms     35.02% Run time
     * 39.6MB  17.72% Memory
     */
    public List<String> restoreIpAddresses(String s) {
        // 本质其实就是在s中确定三个位置放.
        // 先找到中间的那个.
        // 然后分别找第一个和第三个.
        List<String> ans = new ArrayList<>();

        List<Integer> middles = findMiddlePoint(s);
        for (Integer middle : middles) {
            findAndLoadRestPint(s, middle, ans);
        }

        return ans;
    }

    /**
     * 找出中间的那个点
     *
     * @param s
     * @return
     */
    private List<Integer> findMiddlePoint(String s) {
        List<Integer> ans = new ArrayList<>();
        char[] chars = s.toCharArray();

        // 左边的长度不能再2~6之间，右边的长度在2~6之间，然后注意0开头的情况
        for (int i = 0; i < chars.length; i++) {
            // 左边的长度不能小于2
            if (i + 1 < 2) {
                continue;
            }

            // 左边如果是0开头，长度不能超过4
            if (chars[0] == '0' && i + 1 > 4) {
                break;
            }

            // 左边的长度不能超过6
            if (i + 1 > 6) {
                break;
            }

            // 右边长度不能小于2
            if (chars.length - i - 1 < 2) {
                break;
            }

            // 右边如果是0开头，长度不能超过4
            if (chars[i + 1] == '0' && chars.length - i - 1 > 4) {
                continue;
            }

            // 右边的长度不能超过6
            if (chars.length - i - 1 > 6) {
                continue;
            }

            ans.add(i);
        }

        return ans;
    }

    /**
     * 找到剩余的点，并把生成的字符串放进ans内
     *
     * @param s
     * @param middlePoint
     * @param ans
     */
    private void findAndLoadRestPint(String s, int middlePoint, List<String> ans) {
        List<int[]> leftPart = new ArrayList<>();
        List<int[]> rightPart = new ArrayList<>();

        // 找到左右的点
        findPart(s, 0, middlePoint + 1, leftPart);
        findPart(s, middlePoint + 1, s.length(), rightPart);

        for (int[] left : leftPart) {
            for (int[] right : rightPart) {
                ans.add(left[0] + "." + left[1] + "." + right[0] + "." + right[1]);
            }
        }
    }

    /**
     * 找到从[startIndex, end)之间满足条件的所有结果
     *
     * @param s
     * @param startIndex
     * @param end
     * @param part
     */
    private void findPart(String s, int startIndex, int end, List<int[]> part) {
        char[] chars = s.toCharArray();

        for (int i = startIndex; i < end - 1; i++) {
            int p1, p2;

            if (chars[startIndex] == '0') {
                if (chars[startIndex + 1] == '0' && end - startIndex > 2) {
                    break;
                }

                p1 = 0;
                p2 = Integer.parseInt(s.substring(startIndex + 1, end));

                if (p2 <= 255) {
                    int[] temp = new int[]{p1, p2};
                    part.add(temp);
                }

                break;
            } else {
                if (chars[i + 1] == '0' && end > i + 2) {
                    continue;
                }

                p1 = Integer.parseInt(s.substring(startIndex, i + 1));
                p2 = Integer.parseInt(s.substring(i + 1, end));

                if (p1 <= 255 && p2 <= 255) {
                    int[] temp = new int[]{p1, p2};
                    part.add(temp);
                }
            }
        }
    }

}
