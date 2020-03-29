package com.leetcode.merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 *
 * time complexity: n log n
 * space complexity: log n
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0]; // sort in ascending order
            }
        });

        merged.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            // TODO: linked list used for performance improvement
            // refer to sol 2: https://leetcode.com/problems/merge-intervals/solution/
            boolean set = false;

            for (int j = 0; j < merged.size(); j++) {
                if ((intervals[i][0] >= merged.get(j)[0]) && (intervals[i][0] <= merged.get(j)[1])
                        && (intervals[i][1] >= merged.get(j)[1])) {
                    int[] updated = merged.get(j);
                    updated[1] = intervals[i][1];
                    merged.set(j, updated);
                    set = true;
                    break;
                } else if ((intervals[i][0] <= merged.get(j)[0])
                        && (intervals[i][1] >= merged.get(j)[1])) {
                    int[] updated = merged.get(j);
                    updated[0] = intervals[i][0];
                    updated[1] = intervals[i][1];
                    merged.set(j, updated);
                    set = true;
                    break;
                } else if ((intervals[i][0] > merged.get(j)[0])
                        && (intervals[i][1] < merged.get(j)[1])) {
                    set = true;
                    break;
                } else if ((intervals[i][1] >= merged.get(j)[0]) && (intervals[i][1] <= merged.get(j)[1])
                        && (intervals[i][0] <= merged.get(j)[0])) {
                    int[] updated = merged.get(j);
                    updated[0] = intervals[i][0];
                    merged.set(j, updated);
                    set = true;
                    break;
                }
            }

            if (!set) {
                merged.add(intervals[i]);
            }

        }

        return merged.toArray(new int[merged.size()][]);
    }
}
