package com.leetcode.reverse_bits;

public class Solution {
    /**
     * requisites
     *   java int type is represented by 2's complement by design
     *
     *   use '&' and operator to get the least significant bit
     *
     *   refer to https://leetcode.com/problems/reverse-bits/discuss/54738/Sharing-my-2ms-Java-Solution-with-Explanation
     */
    public int reverseBits(int n) {
        int result = 0;
        int i = 0;
        while (i < 32) {
            result <<= 1;
            int beAdded = n & 1;
            result += beAdded;
            n >>= 1;
            i++;
        }

        return result;
    }
}
