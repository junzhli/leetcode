package com.leetcode.longest_common_prefix;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder common = new StringBuilder();
        if (strs.length == 0) {
            return common.toString();
        }

        int maxLength = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < maxLength) {
                maxLength = strs[i].length();
            }
        }

        if (strs[0].length() < maxLength) {
            maxLength = strs[0].length();
        }

        int index = 0;


        while (index != maxLength) {
            int matches = 0;
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(index) == strs[0].charAt(index)) {
                    matches += 1;
                }
            }

            if (matches != (strs.length - 1)) {
                break;
            }
            common.append(strs[0].charAt(index));
            index += 1;
        }

        return common.toString();
    }
}
