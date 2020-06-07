package com.lxr.leetcode;

import org.junit.Test;

import java.util.List;

/**
 * Created by lanxingren on 2020/6/7.
 */
public class TextJustificationTest {

    @Test
    public void fullJustify() {
        String[] data = new String[]{"This", "is", "an", "example", "of", "text", "justification."};

        List<String> ans = new TextJustification().fullJustify(data, 16);

        for (String str : ans) {
            System.out.println(str);
        }
    }

}
