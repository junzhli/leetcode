package com.leetcode.word_search;

/**
 * https://leetcode.com/problems/word-search/
 * Good ans with explanation
 * https://leetcode.com/problems/word-search/discuss/378925/Java-clean-DFS-(Backtracking)-solution-with-explanation
 */
public class Solution {

    // round 2
    // backtracking
    // t.c. o(mn)
    // s.c. o(mn)
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (findPossibility(board, i, j, word, 0, new boolean[board.length][board[0].length])) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean findPossibility(char[][] board,
                                    int x,
                                    int y,
                                    String word,
                                    int indexOf,
                                    boolean[][] visited) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }

        if (visited[x][y]) {
            return false;
        }

        if (board[x][y] != word.charAt(indexOf)) {
            return false;
        }

        if (indexOf == word.length() - 1) {
            return true;
        }

        visited[x][y] = true;

        if (findPossibility(board, x - 1, y, word, indexOf + 1, visited) ||
                findPossibility(board, x + 1, y, word, indexOf + 1, visited) ||
                findPossibility(board, x, y - 1, word, indexOf + 1, visited) ||
                findPossibility(board, x, y + 1, word, indexOf + 1, visited)) {
            return true;
        }



        visited[x][y] = false;
        return false;
    }

    // round 1
//    private boolean[][] inPath;
//
//    public boolean exist(char[][] board, String word) {
//        // edge case handling
//        if (word.length() == 0) {
//            return false;
//        }
//
//        // initialize vars
//        inPath = new boolean[board.length][board[0].length];
//
//        // backtracking starts here
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                if (backtrack(board, word, 0, i, j)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    private boolean backtrack(char[][] board, String word, int indexAt, int x, int y) {
//        if (x < 0 || x > board.length - 1 || y < 0 || y > board[0].length || indexAt > word.length() - 1) {
//            return false;
//        }
//
//        if (inPath[x][y]) {
//            return false;
//        }
//
//        if (board[x][y] != word.charAt(indexAt)) {
//            return false;
//        }
//
//        inPath[x][y] = true;
//        if (indexAt == word.length() - 1) {
//            return true;
//        }
//
//
//        if (backtrack(board, word, indexAt + 1, x - 1, y) ||
//                backtrack(board, word, indexAt + 1, x + 1, y) ||
//                backtrack(board, word, indexAt + 1, x, y - 1) ||
//                backtrack(board, word, indexAt + 1, x, y + 1)) {
//            return true;
//        }
//
//        inPath[x][y] = false;
//        return false;
//    }
}
