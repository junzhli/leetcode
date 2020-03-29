package com.leetcode.set_matrix_zeroes;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 *
 * test cases: [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * test cases: [[1,0,3]]
 *
 * time complexity: o(m * n)
 * space complexity: o(1)
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean col = false;
        boolean row = false;

        if (matrix.length == 0) {
            return;
        }

        boolean firstCol = false;
        if (matrix[0][0] == 0) {
            firstCol = true;
        }

        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] == 0) {
                    if (matrix[i][0] != 0) {
                        matrix[i][0] = 0;
                    }

                    if (matrix[0][j] != 0) {
                        matrix[0][j] = 0;
                    }

                    if (!(i == 0 && j == 0) && (i == 0 || j == 0)) {
                        if (i == 0) {
                            row = true;
                        } else {
                            col = true;
                        }
                    }
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstCol) {
            for (int i = 0; i< matrix.length; i++) {
                matrix[i][0] = 0;
            }

            Arrays.fill(matrix[0], 0);
        }

        if (col) {
            for (int i = 0; i< matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        if (row) {
            Arrays.fill(matrix[0], 0);
        }
    }
}
