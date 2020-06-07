package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 * <p>
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 * <p>
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * <p>
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * <p>
 * Note:
 * <p>
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 * <p>
 * eg1.
 * Input:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * Output:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * <p>
 * eg2.
 * Input:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * Output:
 * [
 * "What   must   be",
 * "acknowledgment  ",
 * "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be",
 * because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified becase it contains only one word.
 * <p>
 * eg3.
 * Input:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 * "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * Output:
 * [
 * "Science  is  what we",
 * "understand      well",
 * "enough to explain to",
 * "a  computer.  Art is",
 * "everything  else  we",
 * "do                  "
 * ]
 */
public class TextJustification {

    /**
     * 1ms      53.14% Run time
     * 37.4MB   90.36% Memory
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();

        // 当前组的单词集合
        List<String> wordList = new ArrayList<>();

        // 当前组单词字符总数
        int charCount = 0;

        // 遍历单词集合，进行分组
        for (int i = 0; i < words.length; i++) {
            String temp = words[i];

            // 字符总和+最少空格数<=maxWidth的情况下
            if (temp.length() + charCount + wordList.size() <= maxWidth) {
                wordList.add(temp);
                charCount = charCount + temp.length();
            } else {
                ans.add(merge(wordList, maxWidth, charCount, false));

                wordList.clear();
                wordList.add(temp);
                charCount = temp.length();
            }

            if (i == words.length - 1) {
                ans.add(merge(wordList, maxWidth, charCount, true));
            }
        }

        return ans;
    }

    /**
     * 将data合并为一个字符串
     *
     * @param data       数据
     * @param maxWidth   最大宽度
     * @param charCount  data中字符串的字符总数
     * @param isLastLine 是否为最后一行
     * @return
     */
    private String merge(List<String> data, int maxWidth, int charCount, boolean isLastLine) {
        StringBuilder stringBuilder = new StringBuilder(maxWidth);

        // 剩余空格数
        int restCount = maxWidth - charCount;

        // 单词之间需要填充的空格数
        int space = 0;

        // 此时单独处理
        if (data.size() == 1) {
            char[] fill = new char[restCount];
            Arrays.fill(fill, ' ');
            stringBuilder.append(data.get(0)).append(fill);

            return stringBuilder.toString();
        }

        // 开始合并
        for (int i = 0; i < data.size(); i++) {
            String temp = data.get(i);

            if (isLastLine) {
                // 最后一行需要左对齐
                space = 1;
            } else {
                // 由于左边的空格需要比右边多，因此存在余数的情况下得加一
                space = restCount / (data.size() - i) + (restCount % (data.size() - i) == 0 ? 0 : 1);
            }

            // 第一个单词
            if (i == 0) {
                stringBuilder.append(temp);
            } else if (i == data.size() - 1) {
                if (isLastLine) {
                    // 最后一行的最后一个单词需要左对齐
                    char[] fill = new char[restCount - 1];
                    Arrays.fill(fill, ' ');
                    stringBuilder.append(' ').append(temp).append(fill);
                } else {
                    // 填充剩余的空格和最后一个单词
                    char[] fill = new char[restCount];
                    Arrays.fill(fill, ' ');
                    stringBuilder.append(fill).append(temp);
                }

                return stringBuilder.toString();
            } else {
                // 填充单词与空格
                char[] fill = new char[space];
                Arrays.fill(fill, ' ');
                stringBuilder.append(fill).append(temp);

                restCount = restCount - space;
            }
        }

        return stringBuilder.toString();
    }

}
