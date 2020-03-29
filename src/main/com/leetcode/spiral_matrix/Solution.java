package com.leetcode.spiral_matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    private int upper, right, down, left;
    private List<Integer> res;

    public List<Integer> spiralOrder(int[][] matrix) {
        res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }

        Direction curr = Direction.UP;
        upper = 0;
        right = matrix[0].length - 1;
        down = matrix.length - 1;
        left = 0;

        int x = -1;
        int y = -1;
        while (true) {
            switch (curr) {
                case RIGHT:
                    curr = Direction.DOWN;
                    x = upper;
                    y = right;
                    break;
                case DOWN:
                    curr = Direction.LEFT;
                    x = down;
                    y = right;
                    break;
                case LEFT:
                    curr = Direction.UP;
                    x = down;
                    y = left;
                    break;
                case UP:
                    curr = Direction.RIGHT;
                    x = upper;
                    y = left;
                    break;
            }
            if (!_spiralOrder(matrix, x, y, curr)) {
                break;
            }
        }

        return res;
    }

    private boolean _spiralOrder(int[][] matrix, int x, int y, Direction curr) {
        boolean clear = true;
        if (curr == Direction.RIGHT) {
            for (int i = y; i <= right; i++) {
                clear = false;
                res.add(matrix[x][i]);
            }
            if (!clear) {
                upper++;
            }
        } else if (curr == Direction.DOWN) {
            for (int i = x; i <= down; i++) {
                clear = false;
                res.add(matrix[i][y]);
            }
            if (!clear) {
                right--;
            }
        } else if (curr == Direction.LEFT) {
            for (int i = y; i >= left; i--) {
                clear = false;
                res.add(matrix[x][i]);
            }
            if (!clear) {
                down--;
            }
        } else {
            // UP
            for (int i = x; i >= upper; i--) {
                clear = false;
                res.add(matrix[i][y]);
            }
            if (!clear) {
                left++;
            }
        }

        return !clear;
    }
}
