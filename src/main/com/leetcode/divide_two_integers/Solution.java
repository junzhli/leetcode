package com.leetcode.divide_two_integers;

public class Solution {
    public int divide(int dividend, int divisor) {
        // skip and return 0 if dividend equals 0
        if (dividend == 0) {
            return 0;
        }

        // sign check
        boolean signed = true;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            signed = false;
        }
        long tmp = dividend;
        long tmp2 = divisor;
        long tmp3 = divisor;
        /**
         * tmp
         */
        if (tmp < 0) {
            tmp = Math.abs(tmp);
        }
        if (tmp2 < 0) {
            tmp2 = Math.abs(tmp2);
            tmp3 = Math.abs(tmp3);
        }

        long q = 1;
        while (tmp - (tmp2 << 1) >= 0) {
            tmp2 <<= 1;
            q <<= 1;
        }

        long res = 0;
        if (q != 1) {
            res = q;
            tmp -= tmp2;
        }

        while (tmp - tmp3 >= 0) {
            tmp -= tmp3;
            res += 1;
        }


        if (signed) {
            res = -res;
        }

        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int) res;
    }
}
