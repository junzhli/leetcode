package com.leetcode.integer_to_roman;

public class Solution {
    /**
     * I             1
     * IV            4
     * V             5
     * IX            9
     * X             10
     * XL            40
     * L             50
     * XC            90
     * C             100
     * CD            400
     * D             500
     * CM            900
     * M             1000
     */

    private static final String[] symbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public String intToRoman(int num) {
        String res = "";
        int index = 0;

        while (num > 0) {
            while (num >= values[index]) {
                res += symbols[index];
                num -= values[index];
            }

            index += 1;
        }

        return res;
    }
}
