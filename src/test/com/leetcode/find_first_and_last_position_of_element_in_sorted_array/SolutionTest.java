package com.leetcode.find_first_and_last_position_of_element_in_sorted_array;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void searchRange() {
        Solution sol = new Solution();
        Assert.assertArrayEquals(new int[] {3,4}, sol.searchRange(new int[]{5,7,7,8,8,10}, 8));
        Assert.assertArrayEquals(new int[] {-1,-1}, sol.searchRange(new int[]{5,7,7,8,8,10}, 6));
        Assert.assertArrayEquals(new int[] {5,5}, sol.searchRange(new int[]{5,7,7,8,8,10}, 10));
        Assert.assertArrayEquals(new int[] {7,8}, sol.searchRange(new int[]{5,7,7,7,7,7,7,8,8}, 8));
    }
}