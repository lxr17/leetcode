package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2019-09-22.
 */
public class ImplementStrTest {

    @Test
    public void strStr() {
        String hay = "aaaaa";
        String needle = "bc";

        int index = new ImplementStr().strStr(hay, needle);

        System.out.println(index);
    }

}
