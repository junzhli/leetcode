package com.leetcode.palindrome_number;

public class Solution {
    private String reverseString(String s) {

        int length = s.length();
        StringBuilder rev = new StringBuilder();
        for (int x = length - 1; x >= 0; x--) {
            rev.append(s.charAt(x));
        }

        return rev.toString();
    }

    public boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        String revStr = reverseString(str);
        return (str.equals(revStr));
    }
}
