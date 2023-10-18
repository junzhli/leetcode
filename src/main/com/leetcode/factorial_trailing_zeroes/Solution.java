package com.leetcode.factorial_trailing_zeroes;

public class Solution {
    // round 2
    // more intuitive but not efficient enough
    public int trailingZeroes(int n) {
        int fives = 0;
        for (int i = 5; i <= n; i = i + 5) {
            fives += countFives(i);
        }
        return fives;
    }

    private int countFives(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 5 != 0) {
                return count;
            }
            n /= 5;
            count++;
        }
        return count;
    }

    // round 1
    // most efficient
//    public int trailingZeroes(int n) {
////        if (n == 0) {
////            return 0;
////        }
////
////        int signed = (n < 0) ? -1 : 1;
////        long upperBound = Math.abs((long) n);
////        int fives = 0;
////        int twos = 0;
////
////        for (int i = 1; i <= upperBound; i++) {
////            int tmp = i;
////            while (tmp % 2 == 0) {
////                tmp /= 2;
////                twos += 1;
////            }
////
////            while (tmp % 5 == 0) {
////                tmp /= 5;
////                fives += 1;
////            }
////        }
////
////        return Math.min(fives, twos) * signed;
//
//        // https://leetcode.com/problems/factorial-trailing-zeroes/discuss/52367/My-explanation-of-the-Log(n)-solution
//        // the number of zeros is denominated by the number of fives, cause the number of twos is always more than the number of fives
//        int signed = (n < 0) ? -1 : 1;
//        long upperBound = Math.abs((long) n);
//        int fives = 0;
//        while (upperBound > 0) {
//            fives += upperBound / 5;
//            upperBound /= 5;
//        }
//
//        return fives * signed;
//    }
}
