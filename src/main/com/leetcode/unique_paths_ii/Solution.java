package com.leetcode.unique_paths_ii;

/**
 * https://leetcode.com/problems/unique-paths-ii/submissions/
 *
 * Approach to this problem: top-bottom with memorization
 *
 * Recursively ask the func itself about the return value of (x - 1, y) + (x, y - 1)
 * Until it comes to (obstacleGrid[x][y] == 1) ==> return 0;
 * Until it comes to (x == 0 || y == 0) ==> check whether its ancestor (y - 1 or x - 1) equals 0 --> return 0, else return 1;
 */
public class Solution {
    private int[][] res;
    private boolean[][] checked;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        res = new int[m][n];
        checked = new boolean[m][n];

        return _uniquePathsWithObstacles(obstacleGrid, m - 1, n - 1);
    }

    private int _uniquePathsWithObstacles(int[][] obstacleGrid, int x, int y) {
        if (checked[x][y]) {
            return res[x][y];
        }

        if (obstacleGrid[x][y] == 1) {
            checked[x][y] = true;
            return res[x][y];
        }

        if (x == 0) {
            if (y > 0 && _uniquePathsWithObstacles(obstacleGrid, x, y - 1) == 0) {
                checked[x][y] = true;
                return res[x][y];
            }
            res[x][y] = 1;
            checked[x][y] = true;
            return res[x][y];
        }

        if (y == 0) {
            if (_uniquePathsWithObstacles(obstacleGrid, x - 1, y) == 0) { // x > 0
                checked[x][y] = true;
                return res[x][y];
            }
            res[x][y] = 1;
            checked[x][y] = true;
            return res[x][y];
        }

        res[x][y] = _uniquePathsWithObstacles(obstacleGrid, x - 1, y) + _uniquePathsWithObstacles(obstacleGrid, x, y - 1);
        checked[x][y] = true;
        return res[x][y];
    }
}
