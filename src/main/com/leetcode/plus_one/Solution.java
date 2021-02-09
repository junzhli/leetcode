package com.leetcode.plus_one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    // round 2
    // t.c. o(len(digits))
    // s.c. o(len(digits))
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return new int[0];
        }

        List<Integer> digitsList = new ArrayList<>();
        for (int d: digits) {
            digitsList.add(d);
        }

        int cursor = digitsList.size() - 1;
        digitsList.set(cursor, digitsList.get(cursor) + 1);
        int carry = 0;
        while (cursor >= 0) {
            int value = digitsList.get(cursor) + carry;
            carry = 0; // !!!!!!**** reset after addition
            if (value >= 10) {
                carry = value / 10;
            }
            digitsList.set(cursor, value % 10);
            cursor--;
        }

        if (carry > 0) {
            digitsList.add(0, carry);
        }

        int[] res = new int[digitsList.size()];
        int i = 0;
        for (Integer t: digitsList) {
            res[i++] = t;
        }
        return res;
    }

    // round 1
//    public int[] plusOne(int[] digits) {
//        int least = digits.length - 1;
//        digits[least] += 1;
//
//        int index = least;
//        while (digits[index] > 9) {
//            if (index - 1 < 0) {
//                digits = insertAtBeginning(digits, 1);
//            } else {
//                digits[--index] += 1;
//            }
//            digits[index + 1] = 0;
//        }
//
//        return digits;
//    }
//
//    private int[] insertAtBeginning(int[] digits, int element) {
//        int[] res = Arrays.copyOf(digits, digits.length + 1);
//        res[0] = element;
//        return res;
//    }
}
