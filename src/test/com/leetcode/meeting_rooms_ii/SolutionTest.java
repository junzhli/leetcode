package com.leetcode.meeting_rooms_ii;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void minMeetingRooms() {
        Solution sol = new Solution();
        List<Solution.Interval> intervals1 = new ArrayList<>();
        intervals1.add(new Solution.Interval(0, 30));
        intervals1.add(new Solution.Interval(5, 10));
        intervals1.add(new Solution.Interval(15, 20));
        int res1 = sol.minMeetingRooms(intervals1);
        assertEquals(2, res1);

        List<Solution.Interval> intervals2 = new ArrayList<>();
        intervals2.add(new Solution.Interval(2, 7));
        int res2 = sol.minMeetingRooms(intervals2);
        assertEquals(1, res2);
    }
}