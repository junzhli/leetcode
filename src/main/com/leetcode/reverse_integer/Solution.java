package com.leetcode.reverse_integer;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    // round 2.1: more elegant and solve without long data type
    // https://leetcode.com/problems/reverse-integer/discuss/4056/Very-Short-(7-lines)-and-Elegant-Solution
    // whatever x is signed or unsigned, we can properly deal this problem with "x%10 ==> either -... or +..."
    // time complexity: len(x.toString)
    // space: o(1)
    public int reverse(int x) {
        int prevRes = 0;
        int res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            if ((res - res % 10) / 10 != prevRes) {
                return 0;
            }
            prevRes = res;
            x /= 10;
        }

        return res;
    }

    // round 2: leverage with parseLong and looping func to create reverse number represented by string
    // time complexity: len(x.toString)
    // space complexity: len(x.toString)
//    public int reverse(int x) {
//        String toStr = String.valueOf(x);
//        boolean signed = (x < 0);
//        String reverseNumber = reverse(signed, toStr);
//        long revNumber = (signed) ? Long.parseLong("-" + reverseNumber) : Long.parseLong(reverseNumber);
//
//        if (revNumber > Integer.MAX_VALUE || revNumber < Integer.MIN_VALUE) {
//            return 0;
//        }
//
//        return (int) revNumber;
//    }
//
//    private String reverse(boolean signed, String number) {
//        StringBuilder strBuilder = new StringBuilder();
//        int end = (signed) ? 1 : 0;
//        for (int i = number.length() - 1; i >= end; i--) {
//            strBuilder.append(number.charAt(i));
//        }
//        return strBuilder.toString();
//    }

    // round 1
//    public int reverse(int x) {
//        List<Integer> arr = new LinkedList<>();
//
//        // if negative, we put aside the sign symbol. Put it back in final step
//        boolean negative = false;
//        if (x < 0) {
//            // check if overflow
//            if (((long) x * (long) -1) > Integer.MAX_VALUE) return 0;
//
//            negative = true;
//            x = x * (-1);
//        }
//
//        // reverse every digits in integer at the time, putting them to linked list
//        int _x = x;
//        while (_x >= 10) {
//            int rem = _x % 10;
//            arr.add(rem);
//            _x = (int) Math.floor(_x / 10);
//        }
//        arr.add(_x);
//
//        boolean overflow = false;
//        long res = 0; // we keep number in long that we can check whether it overflow when it comes with integer.max
//        int ratio = arr.size() - 1;
//        for (int index = 0; index < arr.size(); index++) {
//            int digit = arr.get(index);
//            int hundreds = (int) Math.pow(10, ratio);
//
//            // check if overflow
//            if ((((long) hundreds * (long) digit)) > Integer.MAX_VALUE) {
//                overflow = true;
//                break;
//            }
//            res += hundreds * digit;
//            ratio--;
//        }
//
//        if (overflow || res > Integer.MAX_VALUE) return 0;
//
//        if (negative) res = res * (-1);
//
//        return (int) res;
//    }
}
