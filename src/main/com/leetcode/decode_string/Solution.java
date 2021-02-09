package com.leetcode.decode_string;

public class Solution {
    private int start;

    public String decodeString(String s) {
        if (s.length() < 3) {
            return s;
        }

        start = 0;
        return _decodeString(s);
    }

    private String _decodeString(String s) {
        StringBuilder strBuilder = new StringBuilder();
        int count = 0;
        while (start < s.length()) {
            char currChar = s.charAt(start);
            start++; // !!!
            if (Character.isDigit(currChar)) {
                count = count * 10 + (currChar - '0');
            } else if (currChar == '[') {
                String tmpString = _decodeString(s);
                for (int i = 0; i < count; i++) {
                    strBuilder.append(tmpString);
                }
                count = 0;
            } else if (currChar == ']') {
                break;
            } else {
                strBuilder.append(currChar);
            }
        }
        return strBuilder.toString();
    }
}
