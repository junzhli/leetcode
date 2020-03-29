package com.leetcode.largest_number;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String largestNumber(int[] nums) {
        Comparator<String> comprtr = new Comparator<String>() {
            @Override
            public int compare(String s, String t1) { // sort in lexical order
                String s1 = s + t1;
                String s2 = t1 + s;
                return s2.compareTo(s1); // in reverse order
            }
        };

        String[] arr = new String[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        StringBuilder ret = new StringBuilder();
        Arrays.sort(arr, comprtr);
        for (String a: arr) {
            ret.append(a);
        }

        if (ret.charAt(0) == '0') {
            while (ret.length() > 1 && ret.charAt(0) == '0') {
                ret.deleteCharAt(0);
            }
        }

        return ret.toString();
    }
}
