package io.educative.finding_intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomII {
    public static int minMeetingRooms(int[][] meetingTimes) {
        // t.c. o(nlog(n))
        Arrays.sort(meetingTimes, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                return i1[0] - i2[0];
            }
        });

        // use min heap to push lastEnd
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int[] interval: meetingTimes) {
            int end = interval[1];
            if (queue.isEmpty()) {
                queue.offer(end);
                continue;
            }

            int lastEnd = queue.peek();
            int start = interval[0];
            if (start < lastEnd) {
                // append new one
                queue.offer(end);
            } else {
                queue.poll();
                queue.offer(end);
            }
        }

        return queue.size();
    }
}
