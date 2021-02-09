package com.leetcode.divide_two_integers;

public class Solution {
    // TODO: clear way

    // another way refers to https://www.twblogs.net/a/5c8167d8bd9eee35fc138333

    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }

        // Calculate sign of divisor i.e.,
        // sign will be negative only iff
        // either one of them is negative
        // otherwise it will be positive
        // -, - -> + (T, T -> F)
        // -, + -> - (T, F -> T)
        // +, - -> - (F, T -> T)
        // +, + -> + (F, F -> F)
        int sign = ((dividend < 0) ^
                (divisor < 0)) ? -1 : 1;

        // Update both divisor and
        // dividend positive
        boolean overflow = false;
        if (dividend == Integer.MIN_VALUE) {
            dividend = Integer.MAX_VALUE;
            overflow = true;
        } else {
            dividend = Math.abs(dividend);
        }

        divisor = Math.abs(divisor);

        // Initialize the quotient
        int quotient = 0;

        while (dividend >= divisor)
        {
            dividend -= divisor;
            ++quotient;
        }

        if (overflow) {
            quotient++;
        }

        return sign * quotient;
    }

//    public int divide(int dividend, int divisor) {
//        // skip and return 0 if dividend equals 0
//        if (dividend == 0) {
//            return 0;
//        }
//
//        // sign check
//        boolean signed = true;
//        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
//            signed = false;
//        }
//        long tmp = dividend;
//        long tmp2 = divisor;
//        long tmp3 = divisor;
//        /**
//         * tmp
//         */
//        if (tmp < 0) {
//            tmp = Math.abs(tmp);
//        }
//        if (tmp2 < 0) {
//            tmp2 = Math.abs(tmp2);
//            tmp3 = Math.abs(tmp3);
//        }
//
//        long q = 1;
//        while (tmp - (tmp2 << 1) >= 0) {
//            tmp2 <<= 1;
//            q <<= 1;
//        }
//
//        long res = 0;
//        if (q != 1) {
//            res = q;
//            tmp -= tmp2;
//        }
//
//        while (tmp - tmp3 >= 0) {
//            tmp -= tmp3;
//            res += 1;
//        }
//
//
//        if (signed) {
//            res = -res;
//        }
//
//        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
//            return Integer.MAX_VALUE;
//        }
//
//        return (int) res;
//    }
}
