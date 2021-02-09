package com.leetcode.search_a_2d_matrix;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        if (matrix[0].length == 0) {
            return false;
        }

        int i = 0;
        while (i + 1 < matrix.length && matrix[i + 1][0] <= target) { // can be optimized by binary search
            i++;
        }

        int low = 0;
        int high = matrix[i].length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (matrix[i][mid] < target) {
                low = mid + 1;
            } else if (matrix[i][mid] > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
