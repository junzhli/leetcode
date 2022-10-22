package com.amazon.find_the_point_where_maximum_intervals_overlap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findMaxIntervalsOverlap() {
        int ans = Solution.findMaxIntervalsOverlap(new int[] {1,2,10,5,5}, new int[] {4,5,12,9,12});
        assertEquals(3, ans);
    }
}