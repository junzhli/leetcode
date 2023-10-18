package com.leetcode.number_of_longest_increasing_subsequence;

import java.util.Arrays;

// https://leetcode.com/problems/number-of-longest-increasing-subsequence/solutions/3794723/efficient-dp-solution-lis-beats-98-4/
public class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int max = -1; // we need this max var to keep the max record in the array i.e. not every time we can get longest one from index 0
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] < nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }

                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == max) {
                result += count[i];
            }
        }

        return result;
    }
}
