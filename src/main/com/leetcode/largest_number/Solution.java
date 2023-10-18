package com.leetcode.largest_number;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    // round 2
    // t.c. o(nlog(n))
    // s.c. o(len(numbers in array concatenated into a big number in form of string))
    public String largestNumber(int[] nums) {
        String[] strArr = new String[nums.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String ssA = s1 + s2;
                String ssB = s2 + s1;
                return ssB.compareTo(ssA); // to compare two string based on the unicode value refer to : https://www.w3schools.com/java/ref_string_compareto.asp
            }
        });

        // concentrate strings
        StringBuilder strBuilder = new StringBuilder();
        for (String s: strArr) {
            strBuilder.append(s);
        }

        // remove leading zeros
        if (strBuilder.length() != 0 && strBuilder.charAt(0) == '0') { // !!! '0' --> char, rather than 0
            while (strBuilder.length() > 1 && strBuilder.charAt(0) == '0') {
                strBuilder.deleteCharAt(0);
            }
        }

        return strBuilder.toString();
    }

    // round 1
//    public String largestNumber(int[] nums) {
//        Comparator<String> comprtr = new Comparator<String>() {
//            @Override
//            public int compare(String s, String t1) { // sort in lexical order
//                String s1 = s + t1;
//                String s2 = t1 + s;
//                return s2.compareTo(s1); // in reverse order
//            }
//        };
//
//        String[] arr = new String[nums.length];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = String.valueOf(nums[i]);
//        }
//
//        StringBuilder ret = new StringBuilder();
//        Arrays.sort(arr, comprtr);
//        for (String a: arr) {
//            ret.append(a);
//        }
//
//        if (ret.charAt(0) == '0') {
//            while (ret.length() > 1 && ret.charAt(0) == '0') {
//                ret.deleteCharAt(0);
//            }
//        }
//
//        return ret.toString();
//    }
}
