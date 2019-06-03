package com.leetcode.reverse_integer;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int reverse(int x) {
        List<Integer> arr = new LinkedList<>();

        // if negative, we put aside the sign symbol. Put it back in final step
        boolean negative = false;
        if (x < 0) {
            // check if overflow
            if (((long) x * (long) -1) > Integer.MAX_VALUE) return 0;

            negative = true;
            x = x * (-1);
        }

        // reverse every digits in integer at the time, putting them to linked list
        int _x = x;
        while (_x >= 10) {
            int rem = _x % 10;
            arr.add(rem);
            _x = (int) Math.floor(_x / 10);
        }
        arr.add(_x);

        boolean overflow = false;
        long res = 0; // we keep number in long that we can check whether it overflow when it comes with integer.max
        int ratio = arr.size() - 1;
        for (int index = 0; index < arr.size(); index++) {
            int digit = arr.get(index);
            int hundreds = (int) Math.pow(10, ratio);

            // check if overflow
            if ((((long) hundreds * (long) digit)) > Integer.MAX_VALUE) {
                overflow = true;
                break;
            }
            res += hundreds * digit;
            ratio--;
        }

        if (overflow || res > Integer.MAX_VALUE) return 0;

        if (negative) res = res * (-1);

        return (int) res;
    }
}
