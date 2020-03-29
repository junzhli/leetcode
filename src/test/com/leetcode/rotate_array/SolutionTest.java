package com.leetcode.rotate_array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void rotate() {
        Solution sol = new Solution();
        int[] arg = new int[]{0, 1, 2, 3};
        int[] arg2 = new int[]{0, 1, 2, 3};
        int[] arg3 = new int[]{1, 2};
        sol.rotate(arg, 1);
        Assertions.assertArrayEquals(new int[]{3, 0, 1, 2}, arg);

        sol.rotate(arg2, 0);
        Assertions.assertArrayEquals(new int[]{0, 1, 2, 3}, arg2);

        sol.rotate(arg3, 3);
        Assertions.assertArrayEquals(new int[]{2, 1}, arg3);
    }
}