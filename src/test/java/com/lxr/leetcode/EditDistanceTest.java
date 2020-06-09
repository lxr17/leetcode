package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2020/6/9.
 */
public class EditDistanceTest {

    @Test
    public void minDistance() {
        String w1 = "dinitrophenylhydrazine";
        String w2 = "acetylphenylhydrazine";
        System.out.println(new EditDistance().minDistance(w1, w2));
    }

}
