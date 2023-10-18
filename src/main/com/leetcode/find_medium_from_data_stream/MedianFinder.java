package com.leetcode.find_medium_from_data_stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

// round 2
// t.c. o(nlogn)
// s.c. o(n)
class MedianFinder {
    private PriorityQueue<Integer> max;
    private PriorityQueue<Integer> min;

    public MedianFinder() {
        this.max = new PriorityQueue<>(Collections.reverseOrder()); // max heap for lower pile
        this.min = new PriorityQueue<>(); // min heap for higher pile
    }

    public void addNum(int num) {
        // we have to push to max heap firstly before we eventually push to min heap, since we are unable to ensure the new item is always greater than items in min heap
        max.offer(num); // !!!!
        min.offer(max.poll()); // !!!
        if (min.size() > max.size() + 1) { // for even, both items should be equal in number, for odd, we put the middle item on the right hand
            max.offer(min.poll());
        }
    }

    public double findMedian() {
        if (min.size() == max.size()) {
            return ((double) min.peek() + (double) max.peek()) / 2.0;
        }
        return min.peek();
    }
}


// round 1
// brute force
//class MedianFinder {
//    private ArrayList<Integer> arr;
//
//    public MedianFinder() {
//        this.arr = new ArrayList<>();
//    }
//
//    public void addNum(int num) {
//        this.arr.add(num);
//    }
//
//    public double findMedian() {
//        Collections.sort(arr);
//        if (arr.size() % 2 == 0) {
//            int middleLeft = (arr.size() - 1) / 2;
//            int middleRight = middleLeft + 1;
//            return ((double) arr.get(middleLeft) + (double) arr.get(middleRight)) / 2;
//        } else {
//            int middle = (arr.size()) / 2;
//            return (double) arr.get(middle);
//        }
//    }
//}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
