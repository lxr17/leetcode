package com.lxr.leetcode;

import org.junit.Test;

import java.util.List;

/**
 * Created by lanxingren on 2020-02-23.
 */
public class NQueensTest {

    @Test
    public void solveNQueens() {
        List<List<String>> ans = new NQueens().solveNQueens(5);

        for (List<String> temp : ans) {
            for (String ttt : temp) {
                System.out.println(ttt);
            }

            System.out.println();
        }
     }

}
