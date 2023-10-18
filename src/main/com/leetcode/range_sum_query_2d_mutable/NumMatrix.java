package com.leetcode.range_sum_query_2d_mutable;

// https://leetcode.ca/2016-10-03-308-Range-Sum-Query-2D-Mutable/
// https://leetcode.com/problems/range-sum-query-2d-mutable/?envType=featured-list&envId=top-interview-questions
public class NumMatrix {
    private int[][] sums;

    public NumMatrix(int[][] matrix) {
        this.sums = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == 0) {
                    this.sums[i][j] = matrix[i][j];
                    continue;
                }
                this.sums[i][j] += this.sums[i][j - 1] + matrix[i][j];
            }
        }
    }

    public void update(int row, int col, int val) {
        int diff = (col == 0) ? val - sums[row][col] : val - (sums[row][col] - sums[row][col-1]);
        for (int i = col; i < sums[row].length; i++) {
            sums[row][i] += diff;
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += (col1 == 0) ? sums[i][col2] : (sums[i][col2] - sums[i][col1-1]);
        }

        return sum;
    }
}
