package com.leetcode.roman_to_integer;

import java.util.Arrays;
import java.util.List;

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

    private static final int MAX_POSSIBLE_LENGTH = 2;
    private static final String[] symbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public int romanToInt(String s) {
        int ret = 0;
        List<String> symbolsList = Arrays.asList(symbols);

        while (!s.equals("")) {
            int maxLenSymbol = (s.length() < MAX_POSSIBLE_LENGTH) ? s.length() : MAX_POSSIBLE_LENGTH;


            while (maxLenSymbol > 0) {
                String _symbols = s.substring(0, maxLenSymbol);

                int indexOf = symbolsList.indexOf(_symbols);
                if (indexOf != -1) {
                    ret += values[indexOf];
                    s = s.substring(maxLenSymbol);
                    break;
                }

                maxLenSymbol -= 1;
            }
        }

        return ret;
    }

}
