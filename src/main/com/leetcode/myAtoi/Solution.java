package com.leetcode.myAtoi;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int myAtoi(String str) {
        List<Character> allowed = Arrays.asList(' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '+');
        List<Character> numbers = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        StringBuilder res = new StringBuilder();

        boolean isNegative = false;
        boolean illegal = false;
        boolean hasNumber = false;
        boolean hasSign = false;

        for (int x = 0; x < str.length(); x++) {
            if (!allowed.contains(str.charAt(x))) {
                if (!hasNumber) {
                    illegal = true;
                }
                break;
            }

            if (str.charAt(x) == ' ') {
                if (hasNumber || hasSign) break;

                continue;
            }

            if (str.charAt(x) == '-') {
                if (hasSign && hasNumber) {
                    break;
                }

                if (hasSign) {
                    break;
                }

                if (hasNumber) {
                    break;
                }

                isNegative = true;
                hasSign = true;
                continue;
            }

            if (str.charAt(x) == '+') {
                if (hasSign && hasNumber) {
                    break;
                }

                if (hasSign) {
                    break;
                }

                hasSign = true;
                continue;
            }

            hasNumber = true;
            res.append(str.charAt(x));
        }

        if (illegal) return 0;

        if (res.toString().equals("") || (isNegative && !hasNumber)) {
            return 0;
        }

        BigInteger resNumber = new BigInteger(res.toString());
        BigInteger maxNumber = new BigInteger(String.valueOf(Integer.MAX_VALUE));

        if (resNumber.compareTo(maxNumber) == 1) {
            if (isNegative) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        if (isNegative) {
            return Integer.valueOf(res.toString()) * (-1);
        }

        return Integer.valueOf(res.toString());
    }
}
