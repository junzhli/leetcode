package com.leetcode.number_of_one_bits;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // refer to reverse_bits
        int result = 0;
        int i = 0;
        while (i < 32) {
            result += n & 1;
            n >>= 1;
            i++;
        }
        return result;
    }
}
