package com.leetcode.palindrome_number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void isPalindrome() {
        Solution sol = new Solution();
        // input: 121
        int test1 = 121;
        boolean result1 = sol.isPalindrome(test1);
        // output: true
        assertEquals(true, result1);

        // input: -121
        int test2 = -121;
        boolean result2 = sol.isPalindrome(test2);
        // output: true
        assertEquals(false, result2);

        // input: 10
        int test3 = 10;
        boolean result3 = sol.isPalindrome(test3);
        // output: false
        assertEquals(false, result3);
    }
}