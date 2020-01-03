package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2020-01-03.
 */
public class JumpGameIITest {

    @Test
    public void jump() {
        int[] nums = new int[]{2, 3, 1, 1, 4};

        int ans = new JumpGameII().jump(nums);

        System.out.println(ans);
    }
}
