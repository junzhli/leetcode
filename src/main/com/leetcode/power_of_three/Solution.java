package com.leetcode.power_of_three;

public class Solution {
    public boolean isPowerOfThree(int n) {
        // use 3^19 = 1162261467 to determine, 3^20 is beyond int max value
        if (n <= 0) return false;
        return (1162261467 % n == 0);
    }
}
