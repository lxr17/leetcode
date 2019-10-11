package com.lxr.leetcode;

import org.junit.Test;

/**
 * Created by lanxingren on 2019-10-11.
 */
public class SubstringWithConcatenationOfAllWordsTest {

    @Test
    public void findSubstring() {
        String s = "barfoothefoobarman";
        String[] words = new String[]{""};

        new SubstringWithConcatenationOfAllWords().findSubstring(s, words);
    }

}
