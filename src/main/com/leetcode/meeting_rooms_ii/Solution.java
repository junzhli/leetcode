package com.leetcode.meeting_rooms_ii;

import java.util.*;

// https://www.lintcode.com/problem/meeting-rooms-ii/description
// https://leetcode.com/problems/meeting-rooms-ii/ (locked) 253
public class Solution {
    static class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
    }

    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */

    // key point is A.start >= B.end, room is reusable, otherwise, new room reservation is needed
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // an array of end points for time slots
        for (Interval itv: intervals) {
            if (!minHeap.isEmpty() && itv.start >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.offer(itv.end);
        }
        return minHeap.size();
    }

    // replace with priorityQueue
//    public int minMeetingRooms(List<Interval> intervals) {
//        // Write your code here
//        Collections.sort(intervals, new Comparator<Interval>() {
//            @Override
//            public int compare(Interval o1, Interval o2) {
//                return o1.start - o2.start;
//            }
//        });
//
//        List<List<Interval>> availableRooms = new ArrayList<>();
//        for (Interval itv: intervals) {
//            boolean suitable = false;
//            for (List<Interval> room: availableRooms) {
//                boolean suitable2 = true;
//                for (int i = room.size() - 1; i < room.size() && i >= 0; i++) {
//                    Interval taken = room.get(i);
//                    if (itv.start >= taken.end) {
//                    } else {
//                        suitable2 = false;
//                        break;
//                    }
//                }
//
//                if (suitable2) {
//                    room.add(itv);
//                    suitable = true;
//                    break;
//                }
//            }
//
//            if (!suitable) {
//                List<Interval> newRoom = new ArrayList<>();
//                newRoom.add(itv);
//                availableRooms.add(newRoom);
//            }
//        }
//        return availableRooms.size();
//    }

    // not much efficient enough
    // once sorted, it doesn't need to check if each interval's end is smaller than taken's start
    // it just checks every the last's end of each available room with each interval's start
    // it can optimized with priorityQueue
//    public int minMeetingRooms(List<Interval> intervals) {
//        // Write your code here
//        Collections.sort(intervals, new Comparator<Interval>() {
//            @Override
//            public int compare(Interval o1, Interval o2) {
//                return o1.start - o2.start;
//            }
//        });
//
//        List<List<Interval>> availableRooms = new ArrayList<>();
//        for (Interval itv: intervals) {
//            boolean suitable = false;
//            for (List<Interval> room: availableRooms) {
//                boolean suitable2 = true;
//                for (Interval taken: room) {
//                    if (itv.end <= taken.start || itv.start >= taken.end) {
//                    } else {
//                        suitable2 = false;
//                        break;
//                    }
//                }
//
//                if (suitable2) {
//                    room.add(itv);
//                    suitable = true;
//                    break;
//                }
//            }
//
//            if (!suitable) {
//                List<Interval> newRoom = new ArrayList<>();
//                newRoom.add(itv);
//                availableRooms.add(newRoom);
//            }
//        }
//        return availableRooms.size();
//    }
}
