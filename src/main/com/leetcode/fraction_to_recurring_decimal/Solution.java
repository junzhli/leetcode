package com.leetcode.fraction_to_recurring_decimal;

import java.util.HashMap;

public class Solution {
    // round 3
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        // integral part
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }

        // fractional part
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, res.length());
        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }

    // round 2
    // WRONG
//    public String fractionToDecimal(int numerator, int denominator) {
//        if (numerator == 0) {
//            return String.valueOf(0);
//        }
//
//        boolean signed = ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) ? true : false;
//
//        StringBuilder str = new StringBuilder();
//        if (signed) {
//            str.append("-");
//        }
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        numerator = Math.abs(numerator);
//        denominator = Math.abs(denominator);
//
//        int pos = 0;
//
//        if (numerator >= denominator) {
//            String integral = String.valueOf(numerator / denominator);
//            str.append(integral);
//            numerator = numerator % denominator;
//            pos += integral.length();
//        } else {
//            str.append("0");
//            pos++;
//        }
//
//        if (numerator > 0) {
//            str.append(".");
//            pos++;
//        }
//
//        boolean first = true;
//        while (numerator > 0) {
//            if (!first && map.containsKey(numerator)) {
//                break;
//            }
//
//            if (numerator <  denominator) {
//
//
//                if (first) {
//                    first = false;
//                } else {
//                    map.put(numerator, pos);
//                    str.append("0");
//                    pos++;
//                }
//                numerator *= 10;
//            } else {
//                map.put(numerator, pos);
//                int d = numerator / denominator;
//                int r = numerator % denominator;
//                numerator = r;
//                str.append(String.valueOf(d));
//                pos += 1;
//                first = true;
//            }
//        }
//
//        if (numerator > 0) {
//            str.insert(map.get(numerator), "(");
//            str.insert(str.length(), ")");
//        }
//
//        if (signed) {
//            str.insert(0, "-");
//        }
//
//
//        return str.toString();
//    }

    // round 1
//    public String fractionToDecimal(int numerator, int denominator) {
//        /**
//         * Will it cover repeating sequence of number cases?
//         * i think it covers the multi-repeating character case too. because in the hashmap, we record the mod value. so if this mod value appears again, thats when we know the subsequent operations repeats. and we insert the "(" on the index of the mod, e.g 0.252525252525, we will insert 0."("25, and append the ")" in the end of the string. 0."("25")"
//         */
//
//
//        if (numerator == 0) {
//            return "0";
//        }
//
//        if (denominator == 0) {
//            throw new IllegalArgumentException("divided with 0");
//        }
//
//        StringBuilder ret = new StringBuilder();
//
//        if (numerator < 0 && denominator >= 0 || numerator > 0 && denominator < 0) { // !!! numerator should be  > not >=, zero is not allowed, which equals "0"
//            ret.append("-"); // alternative: (numerator < 0)^(denominator < 0);
//        }
//
//        long a = Math.abs((long) numerator); // type casting is crucial for edge cases !!
//        long b = Math.abs((long) denominator); // type casting is crucial for edge cases !! (e.g. -1, -2147483648)
//        ret.append(a / b);
//
//        long r = a % b;
//        if (r == 0) {
//            return ret.toString();
//        }
//        ret.append(".");
//
//        HashMap<Long, Integer> hashMap = new HashMap<>(); // remainder -> startIndex for ( insertion
//        hashMap.put(r, ret.length());
//        while (r != 0) {
//            r *= 10;
//            ret.append(r / b);
//            r %= b;
//            Integer rIndex = hashMap.get(r);
//            if (rIndex != null) {
//                // print repeating part with ()
//                ret.insert(rIndex, "(");
//                ret.append(")");
//                break;
//            } else {
//                hashMap.put(r, ret.length());
//            }
//
//
////            ret.append(resultPart);
////            if (resultPart != 0) {
////
////            } else {
////                ret.append(resultPart);
////            }
//
//
//        }
//
//        return ret.toString();
//    }
}
