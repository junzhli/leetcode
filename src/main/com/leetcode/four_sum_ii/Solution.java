package com.leetcode.four_sum_ii;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap();

        // A[] + B[] = - (C[] + D[])
        int res = 0;
        for (int a: A) {
            for (int b: B) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }

        for (int c: C) {
            for (int d: D) {
                res += map.getOrDefault(-(c + d), 0);
            }
        }

        return res;
    }


}
