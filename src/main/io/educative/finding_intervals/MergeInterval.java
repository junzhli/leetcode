package io.educative.finding_intervals;

import java.util.*;

/**
 * Point here:
 * t.c. o(n)
 *
 * Solution summary
 *
 * To recap, the solution to this problem can be divided into the following two parts:
 *
 *     Insert the first interval from the input list to the output list.
 *     Traverse the input intervals list. For each interval in the input list:
 *         If the input interval is overlapping with the last interval in the output list, then merge these two intervals and update the last interval of the output list with the merged interval.
 *         Otherwise, add input intervals to the output list.
 *
 * Time complexity
 *
 * The time complexity of this solution is O(n)O(n), where nn is the number of intervals provided in the input.
 * Space complexity
 *
 * The space complexity of this solution is O(n)O(n), as, in the worst case, there will be no overlapping intervals and the result array will store all the intervals.
 */
class MergeInterval {
    public static List <Interval> mergeIntervals(List <Interval> l) {
        // write your code here
        List<Interval> result = new ArrayList<Interval>();
        if (l.size() == 0) {
            return result;
        }

        result.add(l.get(0));

        for (int i = 1; i < l.size(); i++) {
            Interval item = l.get(i);
            Interval lastItem = result.get(result.size() - 1);
            if (isOverlap(item, lastItem)) {
                lastItem.setEnd(Math.max(lastItem.end, item.end));
            } else {
                result.add(item);
            }
        }
        return result;
    }

    // MOST IMPORTANT TO TAKE NOTE
    private static boolean isOverlap(Interval i1, Interval i2) {
        return Math.max(i1.start, i2.start) <= Math.min(i1.end, i2.end); // "=" needed when opened
    }
}
