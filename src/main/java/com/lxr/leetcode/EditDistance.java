package com.lxr.leetcode;

/**
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 * <p>
 * You have the following 3 operations permitted on a word:
 * <p>
 * Insert a character
 * Delete a character
 * Replace a character
 * <p>
 * eg1.
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * <p>
 * eg2.
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 */
public class EditDistance {

    /**
     * 8ms     11.84% Run time
     * 42.1MB  5.03% Memory
     */
    public int minDistance(String word1, String word2) {
        // 由于利用递归的思路可行，但是时间复杂度以及递归层次较高，故舍弃（但思路保留）
        // 采用空间换时间的方式来实现

        int word1Length = word1.length();
        int word2Length = word2.length();

        // 构造一个 (word2Length + 1) * (word1Length + 1) 的数组
        // 其中的 a[i][j] 表示从 word1[0, j] 子串变化到 word2[0, i] 的最少步骤数
        // 例：
        //         null    h    o    r    s    e
        // null       0    1    2    3    4    5
        //    r       1    1    2    2    3    4
        //    o       2    2    1    2    3    4
        //    s       3    3    2    2    2    3
        int[][] data = new int[word2Length + 1][word1Length + 1];

        // 填充首行，从word1的子串变为null只需要删除word1子串长度个字符即可
        for (int j = 0; j < word1Length + 1; j++) {
            data[0][j] = j;
        }

        // 填充首列，从null变为word2的子串只需要新增word2子串长度个字符即可
        for (int i = 0; i < word2Length + 1; i++) {
            data[i][0] = i;
        }

        // 填充剩余空格
        for (int i = 1; i < word2Length + 1; i++) {
            for (int j = 1; j < word1Length + 1; j++) {
                // 当word1[0, j]子串和word2[0, i]子串的最后一个字符一样，
                // 则从word1[0, j]子串变到word[0, i]子串的步骤数等于从word1[0, j - 1]变到word2[0, i - 1]的步骤数
                if (word1.charAt(j - 1) == word2.charAt(i - 1)) {
                    data[i][j] = data[i - 1][j - 1];
                } else {
                    // 已知
                    // word1[0, j] -> word2[0, i - 1] = a[i - 1][j]
                    // word1[0, j - 1] -> word2[0, i - 1] = a[i - 1][j - 1]
                    // word1[0, j - 1] -> word2[0, i] = a[i, j - 1]
                    // 则word1[0, j] -> word2[0, i]有三种方式：

                    // 1. 删除末尾字符：word1[0, j] -> word1[0, j - 1] -> word2[0, i]
                    //    a即为步骤数
                    int a = 1 + data[i][j - 1];

                    // 2. 替换末尾字符，使其与word2[0, i]的末尾字符一致：word1[0, j] -> word1[0, j - 1] -> word2[0, i - 1]
                    //    替换之后相当于从word1[0, j - 1]变到word2[0, i - 1]的步骤数
                    //    b即为步骤数
                    int b = 1 + data[i - 1][j - 1];

                    // 3. 新增一个末尾字符，使其与word2[0, i]的末尾字符一致：word1[0, j] -> word1[0, j] -> word2[0, i - 1]
                    //    新增之后最后一个字符一样，因此步骤数就相当于从word1[0, j]变到word2[0, i - 1]的步骤数
                    //    c即为步骤数
                    int c = 1 + data[i - 1][j];

                    data[i][j] = Integer.min(a, Integer.min(b, c));
                }
            }
        }

        return data[word2Length][word1Length];
    }

    /**
     * 计算w1[w1Index:]子串变化到w2[w2Index:]子串所需要的最少步骤数
     * 该方法的时间复杂度比较高，而且递归层次比较高，故理论上可行，但是太慢
     *
     * @param w1
     * @param w2
     * @param w1Index w1子串的开始索引
     * @param w2Index w2子串的开始索引
     * @return
     */
    private int minDistance(String w1, String w2, int w1Index, int w2Index) {
        // 此时w1子串为空，则变化为w2子串只需要插入w2子串的长度个字符即可
        if (w1Index == w1.length()) {
            return w2.length() - w2Index;
        }

        // 此时w2子串为空，则从w1子串变化为w2子串只需要删除w1子串的长度个字符即可
        if (w2Index == w2.length()) {
            return w1.length() - w1Index;
        }

        // 此时w1子串和w2子串的最首字符一样，因此可以不操作的缩短这两个子串
        if (w1.charAt(w1Index) == w2.charAt(w2Index)) {
            return minDistance(w1, w2, w1Index + 1, w2Index + 1);
        }

        // 此时w1子串和w2子串的首字符不一样，因此需要对w1子串进行编辑操作，以便尽可能缩短w1子串和w2子串的长度

        // 1. 删除w1子串的首字符，故w1子串缩短了，开始索引变为了w1Index + 1，而删除操作为一个步骤，因此得+1
        //    a即为删除操作后所需的最少步骤数
        int a = minDistance(w1, w2, w1Index + 1, w2Index) + 1;

        // 2. 在w1子串开头插入一个首字符（w2子串的首字符），此时w1子串和w2子串开头字符一致，可同时向右移动一个索引来缩短子串长度
        //    由于w1子串先插入后删除，故开头索引没变，而新增操作为一个步骤，因此得+1
        //    b即为插入操作后所需的最少步骤数
        int b = minDistance(w1, w2, w1Index, w2Index + 1) + 1;

        // 3. 将w1子串开头字符替换为w2子串开头字符，此时w1子串和w2子串开头字符一致，可同时向右移动一个索引来缩短子串长度
        //    而替换本身为一个步骤，故得+1
        //    c即为替换操作后所需的最少步骤数
        int c = minDistance(w1, w2, w1Index + 1, w2Index + 1) + 1;

        return Integer.min(a, Integer.min(b, c));
    }

}
