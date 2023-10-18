package com.leetcode.happy_number;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    // round 2
    // https://leetcode.com/problems/happy-number/description/?envType=featured-list&envId=top-interview-questions
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int nextN = n;
        while (!set.contains(nextN)) {
            set.add(nextN);
            int curr = nextN;
            int res = 0;
            while (curr > 0) {
                int r = curr % 10;
                curr = curr / 10;
                res = res + (int) Math.pow(r, 2);
            }
            if (res == 1) {
                return true;
            }
            nextN = res;
        }
        return false;
    }

    // round 1
//    public boolean isHappy(int n) {
//        long tmp = n;
//        HashSet<Long> hashTable = new HashSet<>();
//        while (true) {
//            if (hashTable.contains(tmp)) {
//                break;
//            } else {
//                hashTable.add(tmp);
//            }
//            tmp = happyNumber(tmp);
//        }
//        return tmp == 1;
//    }
//
//    private long happyNumber(long n) {
//        long res = 0;
//        while (n != 0) {
//            long r = n % 10;
//            res += Math.pow(r, 2);
//            n /= 10;
//        }
//        return res;
//    }
}
