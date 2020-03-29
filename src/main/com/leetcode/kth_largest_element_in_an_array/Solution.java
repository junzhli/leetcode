package com.leetcode.kth_largest_element_in_an_array;

import java.util.Arrays;

// https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/60294/Solution-explained
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums); // it runs in n log n time
        return nums[nums.length - k];
        // O(N lg N) running time + O(1) memory
    }

    // follow up: use priority queue class in java which removes element according to specific ordering
//    public int findKthLargest(int[] nums, int k) {
//
//        final PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for(int val : nums) {
//            pq.offer(val);
//
//            if(pq.size() > k) {
//                pq.poll();
//            }
//        }
//        return pq.peek();
    // O(N) best case / O(N^2) worst case running time + O(1) memory
//    }


}
