package com.leetcode.sliding_window_maximum;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/sliding-window-maximum/solutions/458121/java-all-solutions-b-f-pq-deque-dp-with-explanation-and-complexity-analysis/?envType=featured-list&envId=top-interview-questions
public class Solution {
    // using brute force
    //

    // using priority queue
    // cause tle
    // using java built-in pq --> t.c. o(n*k) (since remove method takes o(k)) s.c. o(k)

    // using deque
    // t.c. o(n)
    // s.c. o(k)
    public int[] maxSlidingWindow(int[] nums, int k) {
        // assume nums is not null
        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }
        int[] result = new int[n - k + 1]; // number of windows
        Deque<Integer> win = new ArrayDeque<>(); // stores indices

        // keep offer from rightmost side, poll from leftmost side <---- (this way)
        for (int i = 0; i < n; ++i) {
            // remove indices that are out of bound
            while (win.size() > 0 && win.peekFirst() <= i - k) {
                win.pollFirst();
            }
            // remove indices whose corresponding values are less than nums[i]
            while (win.size() > 0 && nums[win.peekLast()] < nums[i]) {
                win.pollLast();
            }
            // add nums[i]
            win.offerLast(i);
            // add to result
            if (i >= k - 1) { // i - (k+1) >= 0
                result[i - k + 1] = nums[win.peekFirst()];
            }
        }
        return result;
    }
}
