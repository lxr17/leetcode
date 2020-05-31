package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2020/5/31.
 */
public class InsertIntervalTest {

    @Test
    public void insert() {
        int[][] intervals = new int[5][];
        intervals[0] = new int[]{1, 2};
        intervals[1] = new int[]{3, 5};
        intervals[2] = new int[]{6, 7};
        intervals[3] = new int[]{8, 10};
        intervals[4] = new int[]{12, 16};

        int[] newInterval = new int[]{4, 8};

        int[][] aaa = new InsertInterval().insert(intervals, newInterval);
        System.out.println(aaa);
    }

}
