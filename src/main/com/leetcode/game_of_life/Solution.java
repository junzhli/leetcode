package com.leetcode.game_of_life;

public class Solution {
    // https://leetcode.com/problems/game-of-life/discuss/73223/Easiest-JAVA-solution-with-explanation
    //
    // Use 2-bit state represented by int to store two states
    // 01: next state (die), current state (live)
    // 11: next state (live), current state (live) --> apply
    // 00: next state (die), current state (die)
    // 10: next state (live), current state (die) --> apply
    //
    //

    public void gameOfLife(int[][] board) {
        if (board.length == 0) {
            return;
        }

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                apply(board, x, y, board.length, board[0].length);
            }
        }

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                board[x][y] = board[x][y] >> 1;
            }
        }
    }

    private void apply(int[][] board, int x, int y, int xLen, int yLen) {
        int currentState = board[x][y] & 1;
        if (currentState == 0) { // dead cell
            if (sumOfNeighbors(board, x, y, xLen, yLen) == 3) {
                board[x][y] = 2; // 10
            }
        } else { // live cell
            int sum = sumOfNeighbors(board, x, y, xLen, yLen);
            if (sum == 2 || sum == 3) {
                board[x][y] = 3; // 11
            }
        }
    }

    private int sumOfNeighbors(int[][] board, int x, int y, int xLen, int yLen) {
        int ret = 0;
        if (x - 1 >= 0) {
            if (y - 1 >= 0) {
                ret += board[x - 1][y - 1] & 1;
            }
            ret += board[x - 1][y] & 1;
            if (y + 1 < yLen) {
                ret += board[x - 1][y + 1] & 1;
            }
        }

        if (y - 1 >= 0) {
            ret += board[x][y - 1] & 1;
        }
        if (y + 1 < yLen) {
            ret += board[x][y + 1] & 1;
        }

        if (x + 1 < xLen) {
            if (y - 1 >= 0) {
                ret += board[x + 1][y - 1] & 1;
            }
            ret += board[x + 1][y] & 1;
            if (y + 1 < yLen) {
                ret += board[x + 1][y + 1] & 1;
            }
        }

        return ret;
    }

    // not solve in place
//    public void gameOfLife(int[][] board) {
//        if (board.length == 0) {
//            return;
//        }
//        boolean[][] flip = new boolean[board.length][board[0].length];
//        for (int x = 0; x < board.length; x++) {
//            for (int y = 0; y < board[0].length; y++) {
//                flip[x][y] = flipIfNeed(board, x, y, board.length, board[0].length);
//            }
//        }
//
//        for (int x = 0; x < board.length; x++) {
//            for (int y = 0; y < board[0].length; y++) {
//                if (flip[x][y]) {
//                    board[x][y] = (board[x][y] == 1) ? 0 : 1;
//                }
//            }
//        }
//    }
//
//    private boolean flipIfNeed(int[][] board, int x, int y, int xLen, int yLen) {
//        if (board[x][y] == 0) { // dead cell
//            return sumOfNeighbors(board, x, y, xLen, yLen) == 3;
//        } else if (board[x][y] == 1) { // live cell
//            int sum = sumOfNeighbors(board, x, y, xLen, yLen);
//            return (sum < 2 || sum > 3);
//        } else {
//            throw new IllegalStateException("unknown state");
//        }
//    }
//
//    private int sumOfNeighbors(int[][] board, int x, int y, int xLen, int yLen) {
//        int ret = 0;
//        if (x - 1 >= 0) {
//            if (y - 1 >= 0) {
//                ret += board[x - 1][y - 1];
//            }
//            ret += board[x - 1][y];
//            if (y + 1 < yLen) {
//                ret += board[x - 1][y + 1];
//            }
//        }
//
//        if (y - 1 >= 0) {
//            ret += board[x][y - 1];
//        }
//        if (y + 1 < yLen) {
//            ret += board[x][y + 1];
//        }
//
//        if (x + 1 < xLen) {
//            if (y - 1 >= 0) {
//                ret += board[x + 1][y - 1];
//            }
//            ret += board[x + 1][y];
//            if (y + 1 < yLen) {
//                ret += board[x + 1][y + 1];
//            }
//        }
//
//        return ret;
//    }
}
