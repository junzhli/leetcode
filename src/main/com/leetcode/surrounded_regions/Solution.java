package com.leetcode.surrounded_regions;

import utils.Array;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/surrounded-regions/
 * sol: https://leetcode.com/problems/surrounded-regions/discuss/41633/Java-DFS-%2B-boundary-cell-turning-solution-simple-and-clean-code-commented.
 */
public class Solution {
    public void solve(char[][] board) {
        // edge case handling
        if (board.length <= 2 || board[0].length <= 2) {
            return;
        }

        // first, turn all boundary node representing 'O' and its connected node representing 'O' into 'X'
        // cause any node 'o' connected to boundary can't be turned into 'x'
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                markConnectedBoundaryDFS(board, i, 0);
            }

            if (board[i][board[0].length - 1] == 'O') {
                markConnectedBoundaryDFS(board, i, board[0].length - 1);
            }
        }

        for (int j = 0; j <  board[0].length; j++) {
            if (board[0][j] == 'O') {
                markConnectedBoundaryDFS(board, 0, j);
            }

            if (board[board.length - 1][j] == 'O') {
                markConnectedBoundaryDFS(board, board.length - 1, j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <  board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void markConnectedBoundaryDFS(char[][] board, int x, int y) {
        if (x >= board.length || x < 0 || y < 0 || y >= board[0].length) {
            return;
        }

        if (board[x][y] == 'O') {
            board[x][y] = '*';
        }

        if (x + 1 < board.length && board[x + 1][y] == 'O') {
            markConnectedBoundaryDFS(board, x + 1, y);
        }

        if (x - 1 >= 0 && board[x - 1][y] == 'O') {
            markConnectedBoundaryDFS(board, x - 1, y);
        }

        if (y + 1 < board[0].length && board[x][y + 1] == 'O') {
            markConnectedBoundaryDFS(board, x, y + 1);
        }

        if (y - 1 >= 0 && board[x][y - 1] == 'O') {
            markConnectedBoundaryDFS(board, x, y - 1);
        }
    }
}
