package com.leetcode.valid_anagram;

public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] used = new int[26];
        for (char c: s.toCharArray()) {
            used[c - 'a']++;
        }
        for (char c: t.toCharArray()) {
            used[c - 'a']--;
        }
        for (int times: used) {
            if (times != 0) {
                return false;
            }
        }
        return true;
    }
}
