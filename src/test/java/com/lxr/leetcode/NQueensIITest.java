package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2020/3/8.
 */
public class NQueensIITest {

    @Test
    public void totalNQueens() {
        int n = 10;

        int ans = new NQueensII().totalNQueens(n);

        System.out.println(ans);
    }

}
