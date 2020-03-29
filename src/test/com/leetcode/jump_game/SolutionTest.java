package com.leetcode.jump_game;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void canJump() {
        Solution sol = new Solution();
        Assert.assertEquals(false, sol.canJump(new int[]{3,2,1,0,4}));
        Assert.assertEquals(true, sol.canJump(new int[]{2,3,1,1,4}));
        Assert.assertEquals(true, sol.canJump(new int[]{2,5,0,0}));
        Assert.assertEquals(true, sol.canJump(new int[]{3,0,8,2,0,0,1}));
    }
}