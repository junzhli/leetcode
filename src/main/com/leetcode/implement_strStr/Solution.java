package com.leetcode.implement_strStr;

public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        if (haystack.length() == 0) {
            return -1;
        }

        int res = -1;
        char first = needle.charAt(0);
        for (int x = 0; x < haystack.length(); x++) {
            if (haystack.charAt(x) != first) {
                continue;
            }

            int start = x;
            int end = x + needle.length() - 1;
            if (end >= haystack.length()) {
                break;
            }

            int y = 0;
            int z = x;
            while (y < needle.length()) {
                if (haystack.charAt(z) == needle.charAt(y)) {
                    if (y == needle.length() - 1) {
                        res = start;
                    }
                    z++;
                    y++;
                    continue;
                }
                break;
            }

            if (res != -1) {
                break;
            }
        }

        return res;
    }

    // elegant solution derived from leetcode community
//    public int strStr(String haystack, String needle) {
//        for (int i = 0; ; i++) {
//            for (int j = 0; ; j++) {
//                if (j == needle.length()) return i;
//                if (i + j == haystack.length()) return -1;
//                if (needle.charAt(j) != haystack.charAt(i + j)) break;
//            }
//        }
//    }

    // KMP substring search algorithm runs in linear time
    // https://www.youtube.com/watch?v=BXCEFAzhxGY
}
