package com.lxr.leetcode;

import org.junit.Test;

import java.util.List;

public class GrayCodeTest {

    @Test
    public void grayCode() {
        int n = 4;

        List<Integer> ans = new GrayCode().grayCode(n);

        for (int i = 0; i < ans.size(); i++) {
            String sout = Integer.toBinaryString(ans.get(i));
            System.out.println(sout);
        }
    }

}
