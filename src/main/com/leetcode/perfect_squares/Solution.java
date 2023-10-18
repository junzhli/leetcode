package com.leetcode.perfect_squares;

import java.util.ArrayList;
import java.util.Collections;

// https://leetcode.com/problems/perfect-squares/solutions/2837992/java-recursion-memoization-dp-3-square-theorem-explained/?envType=featured-list&envId=top-interview-questions
public class Solution {
    // round 4
    // bottom-up with memorization
//    public int numSquares(int n) {
//        int[] memo = new int[n + 1];
//
//        memo[0] = 0;
//
//        for (int i = 1; i <= n; i++) {
//            memo[i] = i; // 1 + 1 + .... n times
//            for (int j = 1; j * j <= i; j++) {
//                int square = j * j;
//                memo[i] = Math.min(memo[i], 1 + memo[i - square]);
//            }
//        }
//
//        return memo[n];
//    }

    // round 3
    // top-bottom with memorization
//    public int numSquares(int n) {
//        int[] memo = new int[n + 1];
//        return helper(n, memo);
//    }
//
//    private int helper(int n, int[] memo) {
//        if (n < 4) {
//            return n;
//        }
//
//        if (memo[n] != 0) {
//            return memo[n];
//        }
//
//        int ans = n; // 1 + 1 + .... n times
//
//        for (int i = 1; i * i <= n; i++) {
//            int square = i * i;
//            ans = Math.min(ans, 1 + helper(n - square, memo));
//        }
//
//        memo[n] = ans;
//        return ans;
//    }

//    // round 2
//    // recursion
//    // tle
//    public int numSquares(int n) {
//        return helper(n);
//    }
//
//    private int helper(int n) {
//        if (n < 4) {
//            return n;
//        }
//
//        int ans = n; // 1 + 1 + .... n times
//
//        for (int i = 1; i * i <= n; i++) {
//            int square = i * i;
//            ans = Math.min(ans, 1 + helper(n - square));
//        }
//
//        return ans;
//    }


    // round 1
    // tle
//    private int res = Integer.MAX_VALUE;
//
//    public int numSquares(int n) {
//        res = Integer.MAX_VALUE;
//        ArrayList<Integer> squares = buildSquares(n);
//        backtrack(new ArrayList<>(), 0, n, squares);
//        return res;
//    }
//
//    private ArrayList<Integer> buildSquares(int n) {
//        ArrayList<Integer> res = new ArrayList<>();
//        int curr = 0;
//        int square = 1;
//        while (curr < n) {
//            curr = square * square;
//            res.add(curr);
//            square++;
//        }
//        Collections.sort(res, (a1, a2) -> a2 - a1);
//        return res;
//    }
//
//    private void backtrack(ArrayList<Integer> res, int subTotal, int n, ArrayList<Integer> squares) {
//        if (subTotal == n) {
//            this.res = Math.min(res.size(), this.res);
//            return;
//        }
//
//        for (int i = 0; i < squares.size(); i++) {
//            if (subTotal + squares.get(i) > n) {
//                continue;
//            }
//            res.add(squares.get(i));
//            backtrack(res, subTotal + squares.get(i), n, squares);
//            res.remove(res.size() - 1);
//            // if (this.res != -1) {
//            //     return;
//            // }
//        }
//    }
}
