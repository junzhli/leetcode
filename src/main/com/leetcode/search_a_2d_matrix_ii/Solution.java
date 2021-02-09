package com.leetcode.search_a_2d_matrix_ii;

public class Solution {
    // not efficient enough
//    private Boolean[][] visited;
//    private int target;
//    public boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix.length == 0) {
//            return false;
//        }
//
//        if (matrix[0].length == 0) {
//            return false;
//        }
//        /**
//         * [
//         *   [1,   4,  7, 11, 15],
//         *   [2,   5,  8, 12, 19],
//         *   [3,   6,  9, 16, 22],
//         *   [10, 13, 14, 17, 24],
//         *   [18, 21, 23, 26, 30]
//         * ]
//         */
//        visited = new Boolean[matrix.length][matrix[0].length];
//        this.target = target;
//
//        return helper(matrix, 0, 0);
//    }
//
//    private boolean helper(int[][] matrix, int x, int y) {
//        if (visited[x][y] != null) {
//            return false;
//        }
//
//        if (target == matrix[x][y]) {
//            visited[x][y] = true;
//            return true;
//        }
//
//        if (target < matrix[x][y]) {
//            visited[x][y] = true;
//            return false;
//        }
//
//        visited[x][y] = false;
//        if (x + 1 < matrix.length && helper(matrix, x + 1, y)) {
//            return true;
//        }
//
//        if (x - 1 >= 0 && helper(matrix, x - 1, y)) {
//            return true;
//        }
//
//        if (y + 1 < matrix[0].length && helper(matrix, x, y + 1)) {
//            return true;
//        }
//
//        if (y - 1 >= 0 && helper(matrix, x, y - 1)) {
//            return true;
//        }
//
//        visited[x][y] = true;
//        return false;
//    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        if (matrix[0].length == 0) {
            return false;
        }
        /**
         * start from top-right corner, it looks diagonally because of sorted order on rows and columns
         * target < n, go left
         * target > n, go down
         * target == n, return true
         * return false if it exceeds boundary (< 0, > length - 1)
         *
         * [
         *   [1,   4,  7, 11, 15],
         *   [2,   5,  8, 12, 19],
         *   [3,   6,  9, 16, 22],
         *   [10, 13, 14, 17, 24],
         *   [18, 21, 23, 26, 30]
         * ]
         */
        int x = 0;
        int y = matrix[0].length - 1;

        while (x >= 0 && x < matrix.length && y >=0 && y < matrix[0].length) {
            if (target < matrix[x][y]) {
                y--;
            } else if (target > matrix[x][y]) {
                x++;
            } else {
                return true;
            }
        }
        return false;
    }
}
