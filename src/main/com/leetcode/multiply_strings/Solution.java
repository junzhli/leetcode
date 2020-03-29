package com.leetcode.multiply_strings;

/**
 * Graph solution https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
 */
public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.length() == 1 && num1.charAt(0) == '0' || num2.length() == 1 && num2.charAt(0) == '0') {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int subtotal = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j + 1;
                int p2 = i + j;
                subtotal += pos[p1];

                pos[p1] = subtotal % 10;
                pos[p2] += subtotal / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p: pos) {
            if (sb.length() == 0 && p == 0) {
                continue;
            }
            sb.append(p);
        }

        return sb.toString();
    }
}
