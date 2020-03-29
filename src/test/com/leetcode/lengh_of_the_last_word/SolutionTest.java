package com.leetcode.lengh_of_the_last_word;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void lengthOfLastWord() {
        Solution sol = new Solution();
        Assert.assertEquals(4, sol.lengthOfLastWord("h ello"));
        Assert.assertEquals(4, sol.lengthOfLastWord("h ello "));
        Assert.assertEquals(1, sol.lengthOfLastWord("h ell o"));
    }
}