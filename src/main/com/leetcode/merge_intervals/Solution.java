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

    // round 2
    // t.c. o(nlogn)
    // s.c. o(1)
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // the above ensures the ranges in array are sorted, resulting in the situation that we just check if each right side of every range are overlapping or get overlapped !!!!

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            // two cases need to consider:
            // a.....b...c...d
            //
            // a...c.b....d OR
            // a...cdb

            // where (a,b), (c,d)
            int[] aRange = res.get(res.size() - 1);
            int[] bRange = intervals[i];

            if (aRange[1] < bRange[0]) {
                res.add(bRange);
            } else if (aRange[1] >= bRange[0]) {
                aRange[1] = Math.max(aRange[1], bRange[1]);
            } else {
                throw new IllegalStateException("IMPOSSIBLE");
            }
        }

        return res.toArray(new int[res.size()][]);

    }

    // round 1
//    public int[][] merge(int[][] intervals) {
//        if (intervals.length <= 1) {
//            return intervals;
//        }
//
//        List<int[]> merged = new ArrayList<>();
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o2[0] - o1[0]; // sort in ascending order
//            }
//        });
//
//        merged.add(intervals[0]);
//        for (int i = 1; i < intervals.length; i++) {
//            // TODO: linked list used for performance improvement
//            // refer to sol 2: https://leetcode.com/problems/merge-intervals/solution/
//            boolean set = false;
//
//            for (int j = 0; j < merged.size(); j++) {
//                if ((intervals[i][0] >= merged.get(j)[0]) && (intervals[i][0] <= merged.get(j)[1])
//                        && (intervals[i][1] >= merged.get(j)[1])) {
//                    int[] updated = merged.get(j);
//                    updated[1] = intervals[i][1];
//                    merged.set(j, updated);
//                    set = true;
//                    break;
//                } else if ((intervals[i][0] <= merged.get(j)[0])
//                        && (intervals[i][1] >= merged.get(j)[1])) {
//                    int[] updated = merged.get(j);
//                    updated[0] = intervals[i][0];
//                    updated[1] = intervals[i][1];
//                    merged.set(j, updated);
//                    set = true;
//                    break;
//                } else if ((intervals[i][0] > merged.get(j)[0])
//                        && (intervals[i][1] < merged.get(j)[1])) {
//                    set = true;
//                    break;
//                } else if ((intervals[i][1] >= merged.get(j)[0]) && (intervals[i][1] <= merged.get(j)[1])
//                        && (intervals[i][0] <= merged.get(j)[0])) {
//                    int[] updated = merged.get(j);
//                    updated[0] = intervals[i][0];
//                    merged.set(j, updated);
//                    set = true;
//                    break;
//                }
//            }
//
//            if (!set) {
//                merged.add(intervals[i]);
//            }
//
//        }
//
//        return merged.toArray(new int[merged.size()][]);
//    }
}
