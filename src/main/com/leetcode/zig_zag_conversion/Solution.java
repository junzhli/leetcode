package com.leetcode.zig_zag_conversion;

import java.util.Arrays;

public class Solution {
    // returns number of sets which is a row x (row - 1) array
    public int divide(int stringLen, int numRows) {
        return (int) Math.ceil((double) stringLen / numRows);
    }

    // print col x row arrays from left to right, up to bottom.
    public String printHorizontal(char[][] chars, int cols, int rows) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (chars[i][j] == ' ') continue;

                res.append(chars[i][j]);
            }
        }

        return res.toString();
    }

    public String convert(String s, int numRows) {
        int strLength = s.length();

        // returns value without change if length equals 1
        if (numRows == 1) {
            return s;
        } else { // process those greater than 2
            int divs = divide(strLength, numRows);

            int cols = divs * (numRows - 1);
            int rows = numRows;

            // initialize char array of array with null
            char[][] chars = new char[rows][cols];
            for (int a = 0; a < rows; a++) {
                Arrays.fill(chars[a], ' ');
            }

            // less than 3 will have special case written here: no single char in a col here. we just print it out
            if (numRows == 2) {
                int index = 0;

                for (int a = 0; a < cols; a++) {
                    for (int b = 0; b < rows; b++) {
                        if (index >= strLength) continue;

                        chars[b][a] = s.charAt(index);
                        index++;
                    }
                }

                return printHorizontal(chars, cols, rows);
            } else { // greater than 3
                int set = rows - 1;

                int index = 0;
                for (int j = 0; j < cols; j++) {
                    if (index >= strLength) continue;

                    int _set = j % set; // 0: put all chars from up to bottom, k: put a char in (row - 1 - k)

                    if (_set == 0) {
                        for (int k = 0; k < rows; k++) {
                            if (index >= strLength) continue;

                            chars[k][j] = s.charAt(index);
                            index++;
                        }
                    } else {
                        chars[rows - 1 - _set][j] = s.charAt(index);
                        index++;
                    }
                }

                return printHorizontal(chars, cols, rows);
            }
        }
    }
}