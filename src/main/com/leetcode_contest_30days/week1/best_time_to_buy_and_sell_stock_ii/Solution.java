package com.leetcode_contest_30days.week1.best_time_to_buy_and_sell_stock_ii;

import java.util.Arrays;

public class Solution {
    public int numSquares(int n) {
        /**
         * Use dynamic programming (bottom-up):
         * dp[n] = math.min{dp[n - i * i] + dp[i * i], where i * i <= n}: dp[i * i] = 1
         * explanation: https://leetcode.com/problems/perfect-squares/discuss/71587/Explanation-of-the-DP-solution
         *
         * dp[n], which stands for the least number of perfect squares to decompose n
         * Iterate through the array from 0 - n after fills values in the array with 1 except the one at index '0'
         */

        int[] answers = new int[n + 1];
        Arrays.fill(answers, 1);
        answers[0] = 0;
        for (int i = 2; i <= n; i++) {
            int j = 1;
            int tmp = -1;
            int square = (int) Math.pow(j, 2);
            while (i - square >= 0) {
                int comp = answers[i - square] + answers[square];
                if (tmp == -1) {
                    tmp = comp;
                } else {
                    tmp = Math.min(tmp, comp);
                }
                j++;
                square = (int) Math.pow(j, 2);
            }
            answers[i] = tmp;
        }
        return answers[n];
    }
}
