package com.leetcode.fraction_to_recurring_decimal;

import java.util.HashMap;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        /**
         * Will it cover repeating sequence of number cases?
         * i think it covers the multi-repeating character case too. because in the hashmap, we record the mod value. so if this mod value appears again, thats when we know the subsequent operations repeats. and we insert the "(" on the index of the mod, e.g 0.252525252525, we will insert 0."("25, and append the ")" in the end of the string. 0."("25")"
         */


        if (numerator == 0) {
            return "0";
        }

        if (denominator == 0) {
            throw new IllegalArgumentException("divided with 0");
        }

        StringBuilder ret = new StringBuilder();

        if (numerator < 0 && denominator >= 0 || numerator > 0 && denominator < 0) { // !!! numerator should be  > not >=, zero is not allowed, which equals "0"
            ret.append("-"); // alternative: (numerator < 0)^(denominator < 0);
        }

        long a = Math.abs((long) numerator); // type casting is crucial for edge cases !!
        long b = Math.abs((long) denominator); // type casting is crucial for edge cases !! (e.g. -1, -2147483648)
        ret.append(a / b);

        long r = a % b;
        if (r == 0) {
            return ret.toString();
        }
        ret.append(".");

        HashMap<Long, Integer> hashMap = new HashMap<>(); // remainder -> startIndex for ( insertion
        hashMap.put(r, ret.length());
        while (r != 0) {
            r *= 10;
            ret.append(r / b);
            r %= b;
            Integer rIndex = hashMap.get(r);
            if (rIndex != null) {
                // print repeating part with ()
                ret.insert(rIndex, "(");
                ret.append(")");
                break;
            } else {
                hashMap.put(r, ret.length());
            }


//            ret.append(resultPart);
//            if (resultPart != 0) {
//
//            } else {
//                ret.append(resultPart);
//            }


        }

        return ret.toString();
    }
}
