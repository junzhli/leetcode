package com.leetcode.surrounded_regions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solve() {
        Solution sol = new Solution();
        /**
         * [['O','X','X','O','X'],['X','O','O','X','O'],['X','O','X','O','X'],['O','X','O','O','O'],['X','X','O','X','O']]
         */
//        char[][] input = new char[][]{
//                new char[]{'O','X','X','O','X'},
//                new char[]{'X','O','O','X','O'},
//                new char[]{'X','O','X','O','X'},
//                new char[]{'O','X','O','O','O'},
//                new char[]{'X','X','O','X','O'}
//        };

        /**
         * [['O','X','O','O','O','X'],['O','O','X','X','X','O'],['X','X','X','X','X','O'],
         * ['O','O','O','O','X','X'],['X','X','O','O','X','O'],['O','O','X','X','X','X']]
         */
        char[][] input = new char[][]{
                new char[]{'O','X','O','O','O','X'},
                new char[]{'O','O','X','X','X','O'},
                new char[]{'X','X','X','X','X','O'},
                new char[]{'O','O','O','O','X','X'},
                new char[]{'X','X','O','O','X','O'},
                new char[]{'O','O','X','X','X','X'}
        };
        sol.solve(input);
        printCharArr(input);
    }

    private void printCharArr(char[][] arr) {
        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < arr[0].length; x++) {
                System.out.print(arr[y][x]);
            }
            System.out.print('\n');
        }
    }
}