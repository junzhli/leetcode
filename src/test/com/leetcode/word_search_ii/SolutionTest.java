package com.leetcode.word_search_ii;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findWords() {
        Solution sol = new Solution();
        char[][] input = new char[][]{
                new char[]{'o','a','a','n'},
                new char[]{'e','t','a','e'},
                new char[]{'i','h','k','r'},
                new char[]{'i','f','l','v'}
        };
        List<String> result = sol.findWords(input, new String[]{"hklf", "hf"});
        for (String r: result) {
            System.out.println(r);
        }

    }
}