package com.lxr.leetcode;

import org.junit.Test;

import java.util.List;

/**
 * Created by lanxingren on 2019-08-30.
 */
public class LetterCombinationsOfAPhoneNumberTest {

    @Test
    public void letterCombinations() {
        String digits = "23456";

        List<String> list = new LetterCombinationsOfAPhoneNumber().letterCombinations(digits);

        for (String str : list) {
            System.out.println(str);
        }
    }

}
