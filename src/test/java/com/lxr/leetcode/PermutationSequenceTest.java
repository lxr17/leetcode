package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2020/6/1.
 */
public class PermutationSequenceTest {

    @Test
    public void getPermutation() {
        int n = 1;
        int k = 1;

        String xxx = new PermutationSequence().getPermutation(n, k);

        System.out.println(xxx);
    }

}
