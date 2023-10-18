package com.leetcode.longest_increasing_path_in_a_matrix;

import java.util.Arrays;


// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/submissions/?envType=featured-list&envId=top-interview-questions
// t.c. o(n)
// s.c. o(n)
public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int[] arr: dp) {
            Arrays.fill(arr, -1);
        }

        int max = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (dp[i][j] != -1) {
                    continue;
                }

                max = Math.max(max, helper(matrix, i, j, dp));
            }
        }

        return max;
    }

    private int helper(int[][] matrix, int i, int j, int[][] dp) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (i - 1 >= 0 && matrix[i-1][j] > matrix[i][j]) {
            dp[i][j] = Math.max(dp[i][j], 1 + helper(matrix, i-1, j, dp));
        }

        if (i + 1 < matrix.length && matrix[i+1][j] > matrix[i][j]) {
            dp[i][j] = Math.max(dp[i][j], 1 + helper(matrix, i+1, j, dp));
        }

        if (j - 1 >= 0 && matrix[i][j-1] > matrix[i][j]) {
            dp[i][j] = Math.max(dp[i][j], 1 + helper(matrix, i, j-1, dp));
        }

        if (j + 1 < matrix[0].length && matrix[i][j+1] > matrix[i][j]) {
            dp[i][j] = Math.max(dp[i][j], 1 + helper(matrix, i, j+1, dp));
        }

        if (dp[i][j] == -1) {
            dp[i][j] = 1;
        }
        return dp[i][j];
    }
}
