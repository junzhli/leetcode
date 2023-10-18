package io.educative.finding_intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution summary
 *
 * We create a new list where we store all the existing intervals that occur before the start of the interval to be inserted. When we finally run into an overlapping interval, we merge the two together and append the remaining intervals into our output array.
 * Time complexity
 *
 * The time complexity isO(n)O(n), wherennis the number of intervals.
 * Space complexity
 *
 * The space complexity isO(n)O(n), wherennis the number of intervals.
 */
class InsertInterval {

    public static List<Interval> insertInterval(List <Interval> existingIntervals, Interval newInterval) {
        List <Interval> output = new ArrayList<Interval>();
        // Write your code here
        if (existingIntervals.size() == 0) {
            output.add(newInterval);
            return output;
        }

        int i = 0;
        while(i < existingIntervals.size() && existingIntervals.get(i).start < newInterval.start) {
            output.add(existingIntervals.get(i));
        }

        if (i < existingIntervals.size()) {
            
        }

        return output;
    }
}
