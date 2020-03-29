package com.leetcode.number_of_islands;

public class Solution {
    public int numIslands(char[][] grid) {
        // *Flood fill algorithm
        // fill the target(x, y) and all its adjacent with replaced color until it reaches its boundary (the one which color
        // differs from the target color)

        int inc = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == '1') {
                    floodFill(grid, x, y);
                    inc += 1;
                }
            }
        }

        return inc;
    }

    private void floodFill(char[][] grid, int x, int y) {
        if (y < 0 || y >= grid[0].length || x < 0 || x >= grid.length) {
            return;
        }

        if (grid[x][y] == '0') {
            return;
        }

        grid[x][y] = '0';

        floodFill(grid, x + 1, y);
        floodFill(grid, x - 1, y);
        floodFill(grid, x, y - 1);
        floodFill(grid, x, y + 1);
    }
}
