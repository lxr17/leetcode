package com.lxr.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * eg.
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * <p>
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {

    /**
     * 需要极高的空间来存储，故舍弃，但是对于小字符串是没问题的
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        HashMap<Character, Integer> tMap = new HashMap<>();

        // 获取t字符串的所有字符
        for (char ch : t.toCharArray()) {
            if (tMap.get(ch) == null) {
                tMap.put(ch, 1);
            } else {
                tMap.put(ch, tMap.get(ch) + 1);
            }
        }

        // array[x][y]装的是子串 s[x : y] 缺失t中字符的集合
        HashMap<Character, Integer>[][] array = new HashMap[s.length()][s.length()];

        HashMap<Character, Integer> top = null;
        HashMap<Character, Integer> left = null;

        // 遍历，并填入值
        // x\y    0    1    2    3    4
        //   4    /    /    /    /
        //   3    /    /    /
        //   2    /    /
        //   1    /
        //   0
        for (int x = s.length() - 1; x >= 0; x--) {
            for (int y = x; y < s.length(); y++) {
                if (x == s.length() - 1 || array[x + 1][y] == null) {
                    top = tMap;
                } else {
                    top = array[x + 1][y];
                }

                if (y == 0 || array[x][y - 1] == null) {
                    left = tMap;
                } else {
                    left = array[x][y - 1];
                }

                array[x][y] = new HashMap<>();

                if (top.size() != 0 && left.size() != 0) {
                    array[x][y].putAll(left);

                    char curKey = s.charAt(y);
                    Integer curValue = array[x][y].get(curKey);

                    if (curValue != null) {
                        if (curValue == 1) {
                            array[x][y].remove(s.charAt(y));
                        } else {
                            array[x][y].put(curKey, curValue - 1);
                        }
                    }
                }
            }
        }

        int x = 0;
        int y = s.length() - 1;
        boolean isFind = false;

        // 再遍历一遍，找出 y - x 最小的值
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (array[i][j].size() == 0 && j - i <= y - x) {
                    x = i;
                    y = j;
                    isFind = true;
                }
            }
        }

        if (isFind) {
            return s.substring(x, y + 1);
        } else {
            return "";
        }
    }

    /**
     * 这种方法对于长字符串(长度一万左右的字符串)还是会超时，故需要优化
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow2(String s, String t) {
        // 最短子串
        String minSub = s;

        // 先获取t的所有字符
        Map<Character, Integer> tMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        // 获取s的所有字符
        Map<Character, Integer> sMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
        }

        // 首先判断s是否包含t中的所有字符
        Iterator<Character> it = tMap.keySet().iterator();
        while (it.hasNext()) {
            char ch = it.next();

            if (sMap.getOrDefault(ch, 0) < tMap.getOrDefault(ch, 0)) {
                return "";
            }
        }

        // 子串包含字符
        Map<Character, Integer> subMap = new HashMap<>();

        // 临时变量，用来表示子串还缺少的字符情况
        Map<Character, Integer> temp = new HashMap<>(tMap);

        // 左右指针(分别表示子串的左右端)
        int left = 0;
        int right = 0;

        // 用于判断在找子串过程中到底是左端点在移动还是右端点在移动
        // 1代表右端点，-1代表左端点，0代表不移动
        int flag = 1;

        // 1. 固定左端点不动，慢慢往右移动右端点直到包所有字符
        // 2. 固定右端点不动，慢慢往右移动左端点直到该子串为最短子串，此时找到了从左往右数的第一个最短子串
        // 3. 左端点向右移动一个字符
        // 4. 重复1-3，找出所有的最短子串，并返回最最短的子串
        while (left - 1 <= right) {// 因为要判断的子串为s[left - 1 : right]，所以得有这个判断
            // 右端点移动
            if (1 == flag) {
                char ch = s.charAt(right);

                // temp中去掉该字符
                if (temp.get(ch) != null) {
                    if (temp.get(ch) == 1) {
                        temp.remove(ch);
                    } else {
                        temp.put(ch, temp.get(ch) - 1);
                    }
                }

                // subMap中加入该字符
                subMap.put(ch, subMap.getOrDefault(ch, 0) + 1);

                if (temp.size() == 0) {
                    // 此时开始精简子串，故左端点开始移动
                    left++;
                    flag = -1;
                } else {
                    // 稍微注意一下右端点到头的情况
                    if (right < s.length() - 1) {
                        right++;
                        flag = 1;
                    } else {
                        break;
                    }
                }
            } else if (-1 == flag) {// 左端点移动
                char ch = s.charAt(left - 1);

                if (subMap.getOrDefault(ch, 0) > tMap.getOrDefault(ch, 0)) {
                    // 此时可精简
                    if (subMap.get(ch) != null) {
                        if (subMap.get(ch) == 1) {
                            subMap.remove(ch);
                        } else {
                            subMap.put(ch, subMap.get(ch) - 1);
                        }
                    }

                    left++;
                    flag = -1;
                } else if (subMap.getOrDefault(ch, 0) == tMap.getOrDefault(ch, 0)) {
                    // 此时为最短子串
                    if (right - left + 2 < minSub.length()) {
                        minSub = s.substring(left - 1, right + 1);
                    }

                    // 开始寻找第二个最短子串
                    temp.put(ch, 1);

                    // 去掉当前字符(很容易漏掉！)
                    if (subMap.get(ch) != null) {
                        if (subMap.get(ch) == 1) {
                            subMap.remove(ch);
                        } else {
                            subMap.put(ch, subMap.get(ch) - 1);
                        }
                    }

                    // 稍微注意一下右端点到头的情况
                    if (right < s.length() - 1) {
                        right++;
                        flag = 1;
                    } else {
                        break;
                    }
                }

                // 不可能出现第三种情况
            }
        }

        return minSub;
    }

    /**
     * 参考了官方答案
     * 101ms     7.41% Run time
     * 39.9MB    65.16% Memory
     */
    public String minWindow3(String s, String t) {
        Map<Character, Integer> ori = new HashMap<Character, Integer>();
        Map<Character, Integer> cnt = new HashMap<Character, Integer>();

        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check(ori, cnt) && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    private boolean check(Map<Character, Integer> ori, Map<Character, Integer> cnt) {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }

}
