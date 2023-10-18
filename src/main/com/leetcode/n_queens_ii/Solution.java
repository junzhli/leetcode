package com.leetcode.n_queens_ii;

import java.util.HashSet;

// https://leetcode.com/problems/n-queens/description/
public class Solution {
    private int result = 0;

    public int totalNQueens(int n) {
        HashSet<Integer> col = new HashSet<>();
        HashSet<Integer> leftD = new HashSet<>();
        HashSet<Integer> rightD = new HashSet<>();
        helper(col, leftD, rightD, 0, n);
        return result;
    }

    private void helper(HashSet<Integer> col, HashSet<Integer> leftD, HashSet<Integer> rightD, int row, int n) {
        if (row == n) {
            result++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (col.contains(i) || leftD.contains(row + i) || rightD.contains(row - i)) {
                continue;
            }

            col.add(i);
            leftD.add(row + i);
            rightD.add(row - i);
            helper(col, leftD, rightD, row + 1, n);
            rightD.remove(row - i);
            leftD.remove(row + i);
            col.remove(i);
        }
    }
}
