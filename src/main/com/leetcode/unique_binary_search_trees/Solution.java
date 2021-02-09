package com.leetcode.unique_binary_search_trees;

public class Solution {
    // round 1
    // dynamic programming
    // t.c. o(n)
    // s.c. o(n)
    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[21];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        if (n < 4) {
            return dp[n];
        }

        for (int nodes = 4; nodes <= n; nodes++) {
            for (int i = nodes - 1; i >= 0; i--) {
                int j = nodes - 1 - i;
                dp[nodes] += dp[i] * dp[j]; // combinations of left subtree and right subtree
                // get combinations of the followings
                // e.g. n = 5
                //     5          4           3         2             1
                //   /          /    \      /   \      /  \            \
                // {1,2,3,4} {1,2,3} {5} {1,2} {4,5} {1} {3,4,5}  {2,3,4,5}
            }
        }



        return dp[n];
    }
}
