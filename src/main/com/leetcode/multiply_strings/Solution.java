package com.leetcode.multiply_strings;

/**
 * Graph solution https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
 */
public class Solution {

    // round 2
    // do experiment, and you'll realize smaller one = i + j + 1;, larger one (carry) = i + j;
    // time complexity: o(mn)
    // space complexity: o(len(total in string))
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int max = 0;
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int subtotal = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int smaller = i + j + 1;
                int larger = i + j;
                subtotal += res[smaller];
                res[smaller] = subtotal % 10;
                res[larger] += subtotal / 10;
            }
        }



        StringBuilder str = new StringBuilder();
        // skip leading zeros
        int i = 0;
        while (i < res.length && res[i] == 0) {
            i++;
        }

        for (; i < res.length; i++) {
            str.append(String.valueOf(res[i]));
        }

        return str.toString();
    }

    // round 1
//    public String multiply(String num1, String num2) {
//        if (num1.length() == 1 && num1.charAt(0) == '0' || num2.length() == 1 && num2.charAt(0) == '0') {
//            return "0";
//        }
//
//        int m = num1.length();
//        int n = num2.length();
//        int[] pos = new int[m + n];
//
//        for (int i = m - 1; i >= 0; i--) {
//            for (int j = n - 1; j >= 0; j--) {
//                int subtotal = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
//                int p1 = i + j + 1;
//                int p2 = i + j;
//                subtotal += pos[p1];
//
//                pos[p1] = subtotal % 10;
//                pos[p2] += subtotal / 10;
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int p: pos) {
//            if (sb.length() == 0 && p == 0) {
//                continue;
//            }
//            sb.append(p);
//        }
//
//        return sb.toString();
//    }
}
