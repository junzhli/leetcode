package com.leetcode.coin_change;

import java.util.Arrays;

// https://leetcode.com/problems/coin-change/discuss/77368/*Java*-Both-iterative-and-recursive-solutions-with-explanations
public class Solution {
    /**
     * key recursive equation: dp[amount] = Math.min(with loop every element x over coins: dp[amount - x] + 1)
     */

    /**
     * it's in bottom-up manner
     */
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return 0;
        }

        if (amount <= 0) {
            return 0;
        }

        int[] dp = new int[amount + 1]; // every index n stands for the fewest number of combinations to sum up to n
        int sum = 0;

        while (++sum <= amount) {
            int min = Integer.MAX_VALUE;
            for (int coin: coins) {
                if (sum - coin >= 0 && dp[sum - coin] != -1) {
                    dp[sum] = dp[sum - coin] + 1;
                    if (dp[sum] < min) {
                        min = dp[sum];
                    }
                }
            }

            if (min == Integer.MAX_VALUE) {
                dp[sum] = -1;
            } else {
                dp[sum] = min;
            }
        }

        return dp[amount];
    }


    /**
     * it's in top-down manner
     */

//    public int coinChange(int[] coins, int amount) {
//        if (coins.length == 0) {
//            return 0;
//        }
//
//        if (amount <= 0) {
//            return 0;
//        }
//
//        Arrays.sort(coins);
//        return helper(coins, amount, new int[amount + 1]);
//    }
//
//    private int helper(int[] coins, int rem, int[] ret) {
//        if (rem < 0) {
//            return -1;
//        }
//
//        if (rem == 0) {
//            return 0;
//        }
//
//        if (ret[rem] != 0) {
//            return ret[rem];
//        }
//
//        int min = Integer.MAX_VALUE;
//        for (int i = coins.length - 1; i >= 0; i--) {
//            int coin = coins[i];
//            int res = helper(coins, rem - coin, ret);
//            if (res >= 0 && res < min) {
//                min = res + 1;
//            }
//        }
//
//        ret[rem] = (min == Integer.MAX_VALUE) ? -1 : min;
//        return ret[rem];
//    }
}
