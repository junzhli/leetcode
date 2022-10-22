package com.amazon.find_the_point_where_maximum_intervals_overlap;

import java.util.Arrays;

public class Solution {
    //https://www.geeksforgeeks.org/find-the-point-where-maximum-intervals-overlap/
    // time complexity: t.c. o(nlogn)
    public static int findMaxIntervalsOverlap(int[] arrivals, int[] exits) {
        int guests = arrivals.length;
        if (guests == 0) {
            return 0;
        }

        // sort values in both array in order
        // t.c. n(logn)
        Arrays.sort(arrivals);
        Arrays.sort(exits);

        // like merge in merge sort
        int max = 0;
        int i = 0;
        int j = 0;
        int guestIn = 0;

        while (i < guests && j < guests) {
            if (arrivals[i] <= exits[j]) {
                guestIn++;
                max = Math.max(max, guestIn);
                i++;
            } else {
                // arrivals[i] > exits[j]
                guestIn--;
                j++;
            }
        }

        return max;
    }
}
