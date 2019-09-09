package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2019-09-09.
 */
public class RemoveElementTest {

    @Test
    public void removeElement() {
        int[] aaa = new int[]{1, 2, 2, 3, 3, 4, 2, 2, 3, 1, 2};

        new RemoveElement().removeElement(aaa, 2);
    }

}
