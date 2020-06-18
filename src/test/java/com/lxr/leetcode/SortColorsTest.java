package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2020/6/11.
 */
public class SortColorsTest {

    @Test
    public void sortColors() {
        int[] sort = new int[]{2, 0, 2, 1, 1, 0};

        new SortColors().sortColors(sort);

        System.out.println(sort);
    }

}
