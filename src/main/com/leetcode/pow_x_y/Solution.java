package com.leetcode.pow_x_y;

/**
 *
 * TODO: time complexity and calculation time
 * it leads to optimal solution but still have gap between the best and the good one.
 *
 */
public class Solution {
    double nD;
    double tmp;
    boolean minus;
    double res;

//    public double myPow(double x, int n) {
//        double ans = 1;
//        long absN = Math.abs((long)n);
//        while(absN > 0) {
//            if((absN&1)==1) ans *= x;
//            absN >>= 1;
//            x *= x;
//        }
//        return n < 0 ?  1/ans : ans;
//    }

    public double myPow(double x, int n) {

        if (x == 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        nD = n;
        if (n < 0) {
            minus = true;
            nD = -nD;
        } else {
            minus = false;
        }

        tmp = _myPow(x, Math.floor(nD/2));
        if (nD % 2 == 0) {
            res = tmp * tmp;
        } else {
            res = x * tmp * tmp;
        }

        return (minus) ? 1/res : res;
    }

    private double _myPow(double x, double n) {
        if (x == 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        if (n % 2 == 0) {
            // even
            return _myPow(x, Math.floor(n/2)) * _myPow(x, Math.floor(n/2));
        } else {
            // odd
            return x * _myPow(x, Math.floor(n/2)) * _myPow(x, Math.floor(n/2));
        }
    }
}
