package com.leetcode.spiral_matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    // round 2
    // time complexity: o(mn)
    // space complexity: o(mn)
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        if (matrix.length == 0) {
            return res;
        }

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        String curr = "right";
        int i = 0;
        int j = 0;
        while (true) {
            res.add(matrix[i][j]);
            visited[i][j] = true;

            int noway = 0;
            while (true) {
                if (noway > 3) {
                    break;
                }

                switch(curr) {
                    case "right":
                        if (j + 1 >= matrix[0].length || visited[i][j + 1]) {
                            curr = nextStep(curr);
                            noway++;
                            continue;
                        }

                        j++;
                        break;
                    case "down":
                        if (i + 1 >= matrix.length || visited[i + 1][j]) {
                            curr = nextStep(curr);
                            noway++;
                            continue;
                        }

                        i++;
                        break;
                    case "left":
                        if (j - 1 < 0 || visited[i][j - 1]) {
                            curr = nextStep(curr);
                            noway++;
                            continue;
                        }


                        j--;
                        break;
                    case "up":
                        if (i - 1 < 0 || visited[i - 1][j]) {
                            curr = nextStep(curr);
                            noway++;
                            continue;
                        }

                        i--;
                        break;
                }
                break;
            }

            if (noway > 3) {
                break;
            }
        }

        return res;
    }

    private String nextStep(String curr) {
        switch(curr) {
            case "right":
                curr = "down";
                break;
            case "down":
                curr = "left";
                break;
            case "left":
                curr = "up";
                break;
            case "up":
                curr = "right";
                break;
        }
        return curr;
    }


    // round 1
//    enum Direction {
//        UP,
//        DOWN,
//        LEFT,
//        RIGHT
//    }
//
//    private int upper, right, down, left;
//    private List<Integer> res;
//
//    public List<Integer> spiralOrder(int[][] matrix) {
//        res = new ArrayList<>();
//        if (matrix.length == 0) {
//            return res;
//        }
//
//        Direction curr = Direction.UP;
//        upper = 0;
//        right = matrix[0].length - 1;
//        down = matrix.length - 1;
//        left = 0;
//
//        int x = -1;
//        int y = -1;
//        while (true) {
//            switch (curr) {
//                case RIGHT:
//                    curr = Direction.DOWN;
//                    x = upper;
//                    y = right;
//                    break;
//                case DOWN:
//                    curr = Direction.LEFT;
//                    x = down;
//                    y = right;
//                    break;
//                case LEFT:
//                    curr = Direction.UP;
//                    x = down;
//                    y = left;
//                    break;
//                case UP:
//                    curr = Direction.RIGHT;
//                    x = upper;
//                    y = left;
//                    break;
//            }
//            if (!_spiralOrder(matrix, x, y, curr)) {
//                break;
//            }
//        }
//
//        return res;
//    }
//
//    private boolean _spiralOrder(int[][] matrix, int x, int y, Direction curr) {
//        boolean clear = true;
//        if (curr == Direction.RIGHT) {
//            for (int i = y; i <= right; i++) {
//                clear = false;
//                res.add(matrix[x][i]);
//            }
//            if (!clear) {
//                upper++;
//            }
//        } else if (curr == Direction.DOWN) {
//            for (int i = x; i <= down; i++) {
//                clear = false;
//                res.add(matrix[i][y]);
//            }
//            if (!clear) {
//                right--;
//            }
//        } else if (curr == Direction.LEFT) {
//            for (int i = y; i >= left; i--) {
//                clear = false;
//                res.add(matrix[x][i]);
//            }
//            if (!clear) {
//                down--;
//            }
//        } else {
//            // UP
//            for (int i = x; i >= upper; i--) {
//                clear = false;
//                res.add(matrix[i][y]);
//            }
//            if (!clear) {
//                left++;
//            }
//        }
//
//        return !clear;
//    }
}
