package com.leetcode.minimum_path_sum;

/**
 * DP - iteration solution (from bottom to top)
 * minPathSum
 *
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        if (grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        res[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                if (i - 1 >= 0 && j - 1 >= 0) {
                    res[i][j] = Integer.min(res[i - 1][j], res[i][j - 1]) + grid[i][j];
                } else if (i - 1 < 0) {
                    res[i][j] = res[i][j - 1] + grid[i][j];
                } else { // j - 1 < 0
                    res[i][j] = res[i - 1][j] + grid[i][j];
                }
            }
        }

        return res[m - 1][n - 1];
    }
}
