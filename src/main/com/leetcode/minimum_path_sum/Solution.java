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

        int[][] cache = new int[grid.length][grid[0].length];
        return helper(grid, cache, grid.length - 1, grid[0].length - 1);
    }

    private int helper(int[][] grid, int[][] cache, int x, int y) {
        if (x == 0 && y == 0) {
            return grid[0][0];
        }

        if (x < 0 || y < 0) {
            return Integer.MAX_VALUE;
        }

        if (cache[x][y] != 0) {
            return cache[x][y];
        }

        cache[x][y] = Math.min(
                helper(grid, cache, x - 1, y),
                helper(grid, cache, x, y - 1)
        ) + grid[x][y];
        return cache[x][y];
    }
}
