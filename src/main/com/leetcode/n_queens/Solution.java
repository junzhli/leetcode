package com.leetcode.n_queens;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// takeaway of this problem
// observe before moving to impl.
// backtrack is the only way to the solution of the problem
// you'll observe there's only one queen allowed in a col, row, left diagonal and right diagonal
// so you can only focus on iterate rows or column and check if there's conflict by hashset for others
// NOTICE: to check if there's conflict in both left D and right D by using this properties: row+column, row-column
// e.g. chess[0,0] --> 0,0 | chess[1,1] --> 2,0 | 0 <-> 0 detects
// t.c. o(n^2)
// s.c. o(n)
// https://leetcode.com/problems/n-queens/description/
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        HashSet<Integer> colSet = new HashSet<>();
        HashSet<Integer> leftDiagonalSet = new HashSet<>();
        HashSet<Integer> rightDiagnonalSet = new HashSet<>();
        List<List<String>> result = new ArrayList<>();
        helper(colSet, leftDiagonalSet, rightDiagnonalSet, 0, n, new ArrayList<>(), result);
        return result;
    }

    private void helper(
            HashSet<Integer> colSet,
            HashSet<Integer> leftD,
            HashSet<Integer> rightD,
            int row,
            int n,
            List<String> intermediate,
            List<List<String>> result
    ) {
        if (row == n) {
            result.add(new ArrayList<>(intermediate));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (colSet.contains(i) || leftD.contains(row +i) || rightD.contains(row-i)) {
                continue;
            }

            StringBuilder str = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    str.append("Q");
                } else {
                    str.append(".");


                }
            }
            intermediate.add(str.toString());
            colSet.add(i);
            leftD.add(row + i);
            rightD.add(row - i);
            helper(colSet, leftD, rightD, row + 1, n, intermediate, result);
            colSet.remove(i);
            leftD.remove(row + i);
            rightD.remove(row - i);
            intermediate.remove(intermediate.size() - 1);
        }
    }
}
