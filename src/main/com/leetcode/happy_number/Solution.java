package com.leetcode.happy_number;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public boolean isHappy(int n) {
        long tmp = n;
        HashSet<Long> hashTable = new HashSet<>();
        while (true) {
            if (hashTable.contains(tmp)) {
                break;
            } else {
                hashTable.add(tmp);
            }
            tmp = happyNumber(tmp);
        }
        return tmp == 1;
    }

    private long happyNumber(long n) {
        long res = 0;
        while (n != 0) {
            long r = n % 10;
            res += Math.pow(r, 2);
            n /= 10;
        }
        return res;
    }
}
