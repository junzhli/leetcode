package com.leetcode.myAtoi;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    // round 2
    //
    public int myAtoi(String str) {
        List<Character> allowedChars = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '-');

        // length 0, return 0
        if (str.length() == 0) {
            return 0;
        }

        // sequentially check chars whether if it not listed in allowedChars,
        // returns
        int index = 0;
        while (true) {
            if (index >= str.length()) {
                return 0;
            }

            if (allowedChars.contains(str.charAt(index))) {
                break;
            }

            if (str.charAt(index) != ' ') {
                return 0;
            }

            index += 1;
        }

        boolean signSymbol = (str.charAt(index) == '-' || str.charAt(index) == '+');
        if (signSymbol) {
            index += 1;
        }

        boolean isSigned = (signSymbol && str.charAt(index - 1) == '-');

        ArrayList<Integer> arr = new ArrayList<>();
        while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            if (isSigned) {
                arr.add(-(str.charAt(index) - '0'));
            } else {
                arr.add(str.charAt(index) - '0');
            }

            index += 1;
        }

        int res = 0;
        int prevRes = 0;
        for (int i = 0; i < arr.size(); i++) {
            res = res * 10 + arr.get(i);
            if ((res - arr.get(i)) / 10 != prevRes) {
                return (isSigned) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            if (res > 0 && prevRes < 0 || res < 0  && prevRes > 0) {
                return (isSigned) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            prevRes = res;
        }

        return res;
    }


//    public int myAtoi(String str) {
//        List<Character> allowed = Arrays.asList(' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '+');
//        List<Character> numbers = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
//        StringBuilder res = new StringBuilder();
//
//        boolean isNegative = false;
//        boolean illegal = false;
//        boolean hasNumber = false;
//        boolean hasSign = false;
//
//        for (int x = 0; x < str.length(); x++) {
//            if (!allowed.contains(str.charAt(x))) {
//                if (!hasNumber) {
//                    illegal = true;
//                }
//                break;
//            }
//
//            if (str.charAt(x) == ' ') {
//                if (hasNumber || hasSign) break;
//
//                continue;
//            }
//
//            if (str.charAt(x) == '-') {
//                if (hasSign && hasNumber) {
//                    break;
//                }
//
//                if (hasSign) {
//                    break;
//                }
//
//                if (hasNumber) {
//                    break;
//                }
//
//                isNegative = true;
//                hasSign = true;
//                continue;
//            }
//
//            if (str.charAt(x) == '+') {
//                if (hasSign && hasNumber) {
//                    break;
//                }
//
//                if (hasSign) {
//                    break;
//                }
//
//                hasSign = true;
//                continue;
//            }
//
//            hasNumber = true;
//            res.append(str.charAt(x));
//        }
//
//        if (illegal) return 0;
//
//        if (res.toString().equals("") || (isNegative && !hasNumber)) {
//            return 0;
//        }
//
//        BigInteger resNumber = new BigInteger(res.toString());
//        BigInteger maxNumber = new BigInteger(String.valueOf(Integer.MAX_VALUE));
//
//        if (resNumber.compareTo(maxNumber) == 1) {
//            if (isNegative) {
//                return Integer.MIN_VALUE;
//            } else {
//                return Integer.MAX_VALUE;
//            }
//        }
//
//        if (isNegative) {
//            return Integer.valueOf(res.toString()) * (-1);
//        }
//
//        return Integer.valueOf(res.toString());
//    }
}
