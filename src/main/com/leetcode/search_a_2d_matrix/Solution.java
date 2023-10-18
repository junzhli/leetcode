package com.leetcode.search_a_2d_matrix;

class Solution {
    // round 2
    // https://leetcode.com/problems/search-a-2d-matrix-ii/solutions/3767522/java-easy-solution-with-comments/?envType=featured-list&envId=top-interview-questions
    // t.c. o(r+c)
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length-1;
        while(row<matrix.length && col>=0){
            if(matrix[row][col]==target) return true;
            else if(matrix[row][col]<target) row++; //if that element is lesser than target it mean that whole row is useless
            else col--; //if that element is greater than target it mean that column is useless
        }
        return false;
    }

//    public boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix.length == 0) {
//            return false;
//        }
//
//        if (matrix[0].length == 0) {
//            return false;
//        }
//
//        int i = 0;
//        while (i + 1 < matrix.length && matrix[i + 1][0] <= target) { // can be optimized by binary search
//            i++;
//        }
//
//        int low = 0;
//        int high = matrix[i].length - 1;
//        while (low <= high) {
//            int mid = low + (high - low) / 2;
//
//            if (matrix[i][mid] < target) {
//                low = mid + 1;
//            } else if (matrix[i][mid] > target) {
//                high = mid - 1;
//            } else {
//                return true;
//            }
//        }
//
//        return false;
//    }
}
