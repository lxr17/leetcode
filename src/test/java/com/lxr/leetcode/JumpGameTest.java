package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2020/5/28.
 */
public class JumpGameTest {

    @Test
    public void canJump() {
        int[] nums = new int[]{1,2,3};

        boolean canJump = new JumpGame().canJump(nums);

        System.out.println(canJump);
    }

}
