package com.lxr.leetcode;

import org.junit.Test;

import java.util.List;

/**
 * Created by lanxingren on 2020-01-26.
 */
public class GroupAnagramsTest {

    @Test
    public void groupAnagrams() {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> ans = new GroupAnagrams().groupAnagrams(strs);

        System.out.println(ans);
    }
}
