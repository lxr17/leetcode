package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2020/6/7.
 */
public class AddBinaryTest {

    @Test
    public void addBinary() {
        String a = "1011101011101";
        String b = "1";

        System.out.println(Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2)));
        System.out.println(new AddBinary().addBinary(a, b));
    }

}
