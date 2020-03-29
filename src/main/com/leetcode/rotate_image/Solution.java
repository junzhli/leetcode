package com.leetcode.rotate_image;

/**
 * https://leetcode.com/problems/rotate-image/
 */
public class Solution {
    /*
     * clockwise rotate
     * first reverse up to down, then swap the symmetry
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
     */
    public void rotate(int[][] matrix) {
        int half = (int) Math.floor((double) matrix.length / 2);
        reverse(matrix, half);
        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < j; i++) {
                matrix[j][i] ^= matrix[i][j];
                matrix[i][j] ^= matrix[j][i];
                matrix[j][i] ^= matrix[i][j];
            }
        }
    }

    public void reverse(int[][] matrix, int half) {
        int max = matrix.length - 1;
//        if (vertical) {
        for (int i = 0; i < half; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[max - i][j] ^= matrix[i][j];
                matrix[i][j] ^= matrix[max - i][j];
                matrix[max - i][j] ^= matrix[i][j];
            }
        }
//        } else {
//            for (int j = 0; j < half; j++) {
//                for (int i = 0; i < matrix.length; i++) {
//                    matrix[i][max - j] = matrix[i][j];
//                }
//            }
//        }
    }

//    private void swap(int a, int b) {
//        a ^= b;
//        b ^= a;
//        a ^= b;
//    }

//    void rotate(vector<vector<int> > &matrix) {
//        reverse(matrix.begin(), matrix.end());
//        for (int i = 0; i < matrix.size(); ++i) {
//            for (int j = i + 1; j < matrix[i].size(); ++j)
//                swap(matrix[i][j], matrix[j][i]);
//        }
//    }

    /*
     * anticlockwise rotate
     * first reverse left to right, then swap the symmetry
     * 1 2 3     3 2 1     3 6 9
     * 4 5 6  => 6 5 4  => 2 5 8
     * 7 8 9     9 8 7     1 4 7
     */
//    void anti_rotate(vector<vector<int> > &matrix) {
//        for (auto vi : matrix) reverse(vi.begin(), vi.end());
//        for (int i = 0; i < matrix.size(); ++i) {
//            for (int j = i + 1; j < matrix[i].size(); ++j)
//                swap(matrix[i][j], matrix[j][i]);
//        }
//    }
}
