package com.leetcode.word_search;

/**
 * https://leetcode.com/problems/word-search/
 * Good ans with explanation
 * https://leetcode.com/problems/word-search/discuss/378925/Java-clean-DFS-(Backtracking)-solution-with-explanation
 */
public class Solution {
    private boolean[][] inPath;

    public boolean exist(char[][] board, String word) {
        // edge case handling
        if (word.length() == 0) {
            return false;
        }

        // initialize vars
        inPath = new boolean[board.length][board[0].length];

        // backtracking starts here
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (backtrack(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int indexAt, int x, int y) {
        if (x < 0 || x > board.length - 1 || y < 0 || y > board[0].length || indexAt > word.length() - 1) {
            return false;
        }

        if (inPath[x][y]) {
            return false;
        }

        if (board[x][y] != word.charAt(indexAt)) {
            return false;
        }

        inPath[x][y] = true;
        if (indexAt == word.length() - 1) {
            return true;
        }


        if (backtrack(board, word, indexAt + 1, x - 1, y) ||
                backtrack(board, word, indexAt + 1, x + 1, y) ||
                backtrack(board, word, indexAt + 1, x, y - 1) ||
                backtrack(board, word, indexAt + 1, x, y + 1)) {
            return true;
        }

        inPath[x][y] = false;
        return false;
    }
}
