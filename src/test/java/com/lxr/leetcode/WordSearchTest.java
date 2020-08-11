package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2020/7/2.
 */
public class WordSearchTest {

    @Test
    public void exist() {
        char[][] board = new char[3][4];

        board[0] = new char[]{'A', 'B', 'C', 'E'};
        board[1] = new char[]{'S', 'F', 'C', 'S'};
        board[2] = new char[]{'A', 'D', 'E', 'E'};

        String word = "ABCCFS";

        boolean ans = new WordSearch().exist2(board, word);

        System.out.println(ans);
    }

}
