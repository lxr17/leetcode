package com.lxr.leetcode;

import org.junit.Test;

import java.util.List;

public class RestoreIPAddressesTest {

    @Test
    public void restoreIpAddresses() {
        String s = "010010";

        List<String> ans = new RestoreIPAddresses().restoreIpAddresses(s);

        System.out.println(ans);
    }

}
