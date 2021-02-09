package com.leetcode.reverse_string;

public class Solution {
    public void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1 - i; j - i > 0; i++, j = s.length - 1 - i) {
            swap(s, i , j);
        }
    }

    private void swap(char[] s, int x, int y) {
        char tmp;
        tmp = s[x];
        s[x] = s[y];
        s[y] = tmp;
    }
}
