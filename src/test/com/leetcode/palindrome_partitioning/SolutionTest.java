package com.leetcode.palindrome_partitioning;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void partition() {
        Solution sol = new Solution();
        List<List<String>> ans = sol.partition("aabbaab");
        printAns(ans);
    }

    private void printAns(List<List<String>> ans) {
        for (List<String> a: ans) {
            for (String b: a) {
                System.out.print(b + " ");
            }

            System.out.print('\n');
        }
    }
}