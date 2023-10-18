package com.leetcode.design_tic_tac_toe;

// yet to be validated
class TicTacToe {
    class AlreadyTakenException extends Exception {

    }

    class GameEndException extends Exception {

    }

    // int = 0 --> no player taking this space
    // int = 1 --> 'x'
    // int = 2 --> 'o'
    private int[][] board;
    private boolean whoTurn; // false: 'x', true: 'o'
    private boolean isWin;
    private boolean endGame;
    private int rounds;


    /** Initialize your data structure here. */
    public TicTacToe() {
        this.board = new int[3][3];
        this.whoTurn = false;
        this.isWin = false;
        this.endGame = false;
        this.rounds = 0;
    }
    
    public boolean move(int row, int col) throws AlreadyTakenException, GameEndException {
        if (isWin) {
            throw new GameEndException();
        }

        if (endGame) {
            System.out.println("it's a draw");
            return false;
        }

        if (board[row][col] != 0) {
            throw new AlreadyTakenException();
        }
        int player = whoTurn ? 2 : 1;
        board[row][col] = player;
        isGonnaWin(row, col);

        if (++this.rounds == 9) {
            endGame = true;
        }

        changePlayer();

        return isWin;
    }

    private void changePlayer() {
        this.whoTurn = !this.whoTurn;
    }

    private void isGonnaWin(int row, int col) {
        int player = board[row][col];

        int same = 0;
        for (int i = 0; i < 3; i++) {
            if (board[row][i] != player) {
                break;
            }
            same++;
        }
        if (same == 3) {
            markWin();
            return;
        }

        same = 0;
        for (int i = 0; i < 3; i++) {
            if (board[i][col] != player) {
                break;
            }
            same++;
        }
        if (same == 3) {
            markWin();
            return;
        }

        if (col + row == 2) {
            same = 0;
            for (int i = 0; i < 3; i++) {
                if (board[i][i] != player) {
                    break;
                }
                same++;
            }
            if (same == 3) {
                markWin();
                return;
            }

            same = 0;
            for (int i = 0; i < 3; i++) {
                if (board[2 - i][i] != player) {
                    break;
                }
                same++;
            }
            if (same == 3) {
                markWin();
                return;
            }
        }
    }

    private void markWin() {
        isWin = true;
        endGame = true;
    }
}
