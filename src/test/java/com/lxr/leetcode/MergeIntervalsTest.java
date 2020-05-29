package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2020/5/29.
 */
public class MergeIntervalsTest {

    @Test
    public void merge() {

//        int[][] data = new int[4][2];
//        data[0] = new int[]{1, 2};
//        data[1] = new int[]{2, 6};
//        data[2] = new int[]{8, 10};
//        data[3] = new int[]{15, 18};

        int[][] data = new int[2][2];
        data[0] = new int[]{1, 4};
        data[1] = new int[]{0, 0};

//        int[][] data = new int[3][2];
//        data[0] = new int[]{1, 4};
//        data[1] = new int[]{0, 2};
//        data[2] = new int[]{3, 5};

        new MergeIntervals().merge(data);

    }

}
