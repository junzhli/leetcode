package com.leetcode.lengh_of_the_last_word;

/**
 * https://leetcode.com/problems/length-of-last-word/
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int pointer = s.length() - 1;
        while (pointer >= 0 && s.charAt(pointer) == ' ') {
            pointer -= 1;
        }

        int len = 0;
        while (pointer >= 0 && s.charAt(pointer) != ' ') {
            pointer -= 1;
            len += 1;
        }

        return len;
    }
}
