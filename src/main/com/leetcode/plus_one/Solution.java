package com.leetcode.plus_one;

import java.util.Arrays;

public class Solution {
    public int[] plusOne(int[] digits) {
        int least = digits.length - 1;
        digits[least] += 1;

        int index = least;
        while (digits[index] > 9) {
            if (index - 1 < 0) {
                digits = insertAtBeginning(digits, 1);
            } else {
                digits[--index] += 1;
            }
            digits[index + 1] = 0;
        }

        return digits;
    }

    private int[] insertAtBeginning(int[] digits, int element) {
        int[] res = Arrays.copyOf(digits, digits.length + 1);
        res[0] = element;
        return res;
    }
}
