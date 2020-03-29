package com.leetcode.unique_paths;

public class Solution {
    /**
     * https://leetcode.com/problems/unique-paths (d.p.)
     */
    public int uniquePaths(int m, int n) {
        /**
         * dynamic programming is meant to keep every result of every sub-problem to prevent recalculation and finally comes out the final result derived from sub-problems
         *
         * here 'cache' stores result of m, n which indicates number of combinations of steps to reach to p(m, n)
         * it turns out to be the final value we expect to see cache(m - 1, n - 1)
         * note that cache[i][j] = 0 when i == 0 or j == 0 as those p(i, j) only has one way to reach (by moves: right, down)
         * . .-> * . . .
         * . .   . . . .
         * |
         * # .   . . . . (cache(*)), (cache(#))
         */

        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    cache[i][j] = 1;
                } else {
                    cache[i][j] = cache[i - 1][j] + cache[i][j - 1];
                }
            }
        }

        return cache[m - 1][n - 1];
    }

}
