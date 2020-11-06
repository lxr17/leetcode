package com.lxr.leetcode;

/**
 * We can scramble a string s to get a string t using the following algorithm:
 * 1. If the length of the string is 1, stop.
 * 2. If the length of the string is > 1, do the following:
 * <p>
 * Split the string into two non-empty substrings at a random index, i.e., if the string is s, divide it to x and y where s = x + y.
 * Randomly decide to swap the two substrings or to keep them in the same order. i.e., after this step, s may become s = x + y or s = y + x.
 * Apply step 1 recursively on each of the two substrings x and y.
 * <p>
 * Given two strings s1 and s2 of the same length, return true if s2 is a scrambled string of s1, otherwise, return false.
 * <p>
 * eg1.
 * Input: s1 = "great", s2 = "rgeat"
 * Output: true
 * Explanation: One possible scenario applied on s1 is:
 * "great" --> "gr/eat" // divide at random index.
 * "gr/eat" --> "gr/eat" // random decision is not to swap the two substrings and keep them in order.
 * "gr/eat" --> "g/r / e/at" // apply the same algorithm recursively on both substrings. divide at ranom index each of them.
 * "g/r / e/at" --> "r/g / e/at" // random decision was to swap the first substring and to keep the second substring in the same order.
 * "r/g / e/at" --> "r/g / e/ a/t" // again apply the algorithm recursively, divide "at" to "a/t".
 * "r/g / e/ a/t" --> "r/g / e/ a/t" // random decision is to keep both substrings in the same order.
 * The algorithm stops now and the result string is "rgeat" which is s2.
 * As there is one possible scenario that led s1 to be scrambled to s2, we return true.
 * <p>
 * eg2.
 * Input: s1 = "abcde", s2 = "caebd"
 * Output: false
 * <p>
 * eg3.
 * Input: s1 = "a", s2 = "a"
 * Output: true
 * <p>
 * Constraints:
 * s1.length == s2.length
 * 1 <= s1.length <= 30
 * s1 and s2 consist of lower-case English letters.
 */
public class ScrambleString {

    // timeout了
    public boolean isScramble(String s1, String s2) {
        // 长度不同择不匹配
        if (s1.length() != s2.length()) {
            return false;
        }

        // 如果s2的长度只有1，择直接匹配
        if (s2.length() == 1 && s1.equals(s2)) {
            return true;
        }

        // 分段，然后判断
        for (int index = 1; index < s2.length(); index++) {
            String temp1 = s2.substring(0, index);
            String temp2 = s2.substring(index);

            if ((isScramble(temp1, s1.substring(0, index)) && isScramble(temp2, s1.substring(index)))
                    || (isScramble(temp1, s1.substring(s1.length() - index)) && isScramble(temp2, s1.substring(0, s1.length() - index)))) {
                return true;
            }
        }

        return false;
    }

}
