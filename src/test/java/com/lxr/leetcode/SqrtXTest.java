package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2020/6/7.
 */
public class SqrtXTest {

    @Test
    public void mySqrt() {
        int x = 4;
        int ans = new SqrtX().mySqrt(x);

        System.out.println(ans);
        System.out.println((int) Math.sqrt(x));
    }

}
