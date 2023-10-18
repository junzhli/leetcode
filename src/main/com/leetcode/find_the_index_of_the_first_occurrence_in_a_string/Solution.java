package com.leetcode.find_the_index_of_the_first_occurrence_in_a_string;

// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
// t.c. o(length haystack * length needle)
// s.c. o(1)

// tips java String.indexOf (substring) ==> returns the index of first occurrence of substring in string
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || haystack == null) {
            return -1;
        }

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if ((haystack.charAt(i + j) == needle.charAt(j)) && (j == needle.length() - 1)) {
                    return i;
                }
            }
        }

        return -1;
    }
}