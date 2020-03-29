package com.leetcode.decode_ways;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
// https://leetcode.com/problems/decode-ways/discuss/390454/Java-DP-solution-simple-and-clean-with-explanation
public class Solution {
    /**
     * Cached recursion
     */
//    public int numDecodings(String s) {
//        if (s.length() == 0) { // returns 0 if string is empty according to the problem statement
//            return 0;
//        }
//        int single = Integer.parseInt(s.substring(0, 1));
//        if (s.length() == 1) {
//            if (single != 0) {
//                return 1;
//            }
//            return 0;
//        }
//        if (single == 0) {
//            return 0;
//        }
//
//        // str with length >= 2
//        // with the range from 1 to 26 indicates chars respectively
//        Integer[] res = new Integer[s.length() + 1];
//        res[0] = 1; // set to 1 cause it is a special case here. we return 1 cause we have to make res[2] valid.
//        res[1] = 1; // represents string with length 1
//        return numDecodings(s, res, s.length());
//    }

//    private int numDecodings(String s, Integer[] res, int index) {
//        if (index <= 1) {
//            return res[index];
//        }
//        if (res[index] != null) {
//            return res[index];
//        }
//        res[index] = 0;
//        int single = Integer.parseInt(s.substring(index - 1, index));
//        int dbl = Integer.parseInt(s.substring(index - 2, index));
//        if (single != 0) { // 1 ~ 9
//            res[index] += numDecodings(s, res, index - 1);
//        }
//        if (dbl >= 10 && dbl <= 26) {
//            res[index] += numDecodings(s, res, index - 2);
//        }
//        return res[index];
//    }

    /**
     * Toward DP
     */
    public int numDecodings(String s) {
        if (s.length() == 0) { // returns 0 if string is empty according to the problem statement
            return 0;
        }
        int single = Integer.parseInt(s.substring(0, 1));
        if (s.length() == 1) {
            if (single != 0) {
                return 1;
            }
            return 0;
        }
        if (single == 0) {
            return 0;
        }

        // str with length >= 2
        // with the range from 1 to 26 indicates chars respectively
        Integer[] res = new Integer[s.length() + 1];
        res[0] = 1; // set to 1 cause it is a special case here. we return 1 cause we have to make res[2] valid.
        res[1] = 1; // represents string with length 1
        for (int i = 2; i <= s.length(); i++) {
            numDecodings(s, res, i);
        }
        return res[res.length - 1];
    }

    private void numDecodings(String s, Integer[] res, int index) {
        // handles cases in the range starting from 2
        res[index] = 0;
        int single = Integer.parseInt(s.substring(index - 1, index));
        int dbl = Integer.parseInt(s.substring(index - 2, index));
        if (single != 0) { // 1 ~ 9
            res[index] += res[index - 1];
        }
        if (dbl >= 10 && dbl <= 26) {
            res[index] += res[index - 2];
        }
    }
}

