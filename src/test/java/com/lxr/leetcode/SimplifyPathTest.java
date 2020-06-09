package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2020/6/9.
 */
public class SimplifyPathTest {

    @Test
    public void simplifyPath() {
        String path = "/../";

        String ans = new SimplifyPath().simplifyPath(path);

        System.out.println(ans);
    }

}
