package com.leetcode.excel_sheet_column_number;

public class Solution {
    public int titleToNumber(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int res = 0;
        int multiplier = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            res += (s.charAt(i) - 64) * Math.pow(26, multiplier); // 64 = 'A'
            multiplier--;
        }

        return res;
    }
}
