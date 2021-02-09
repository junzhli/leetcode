package com.leetcode.longest_common_prefix;

class Solution {
    // round 2
    // time complexity: o(maxStr±subtracted)
    // space complexity: o(1)
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            while (prefix.length() > 0) {
                if (!strs[i].startsWith(prefix)) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                }
            }
        }

        return prefix;
    }


    // round 1
//    public String longestCommonPrefix(String[] strs) {
//        StringBuilder common = new StringBuilder();
//        if (strs.length == 0) {
//            return common.toString();
//        }
//
//        int maxLength = strs[0].length();
//        for (int i = 1; i < strs.length; i++) {
//            if (strs[i].length() < maxLength) {
//                maxLength = strs[i].length();
//            }
//        }
//
//        if (strs[0].length() < maxLength) {
//            maxLength = strs[0].length();
//        }
//
//        int index = 0;
//
//
//        while (index != maxLength) {
//            int matches = 0;
//            for (int i = 1; i < strs.length; i++) {
//                if (strs[i].charAt(index) == strs[0].charAt(index)) {
//                    matches += 1;
//                }
//            }
//
//            if (matches != (strs.length - 1)) {
//                break;
//            }
//            common.append(strs[0].charAt(index));
//            index += 1;
//        }
//
//        return common.toString();
//    }
}
