package com.leetcode.kth_largest_element_in_an_array;

import java.util.Arrays;

// https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/60294/Solution-explained
public class Solution {
    // round 2
    // t.c. avg o(n), worst o(n^2), ... n + n/2 + n/4 .... < 2n
    // s.c. o(1)
    public int findKthLargest(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        k = (nums.length - k);
        while (start <= end) { // why <=, rather than <: for case of array with length 1. e.g. [1]
            int pivot = partition(nums, start, end);
            if (pivot < k) {
                start = pivot + 1;
            } else if (pivot > k) {
                end = pivot - 1;
            } else {
                return nums[pivot];
            }
        }
        return -1;
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];

        int i = start; // denotes lower bound
        int j = start; // denotes current index of looping array
        for (; j < end; j++) {
            if (nums[j] <= pivot) {
                swap(i++, j, nums);
            }
        }

        swap(i, end, nums);
        return i;
    }

    private void swap(int x, int y, int[] nums) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    // round 1
//    public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums); // it runs in n log n time
//        return nums[nums.length - k];
//        // O(N lg N) running time + O(1) memory
//    }
//
//    // follow up: use priority queue class in java which removes element according to specific ordering
////    public int findKthLargest(int[] nums, int k) {
////
////        final PriorityQueue<Integer> pq = new PriorityQueue<>();
////        for(int val : nums) {
////            pq.offer(val);
////
////            if(pq.size() > k) {
////                pq.poll();
////            }
////        }
////        return pq.peek();
//    // O(N) best case / O(N^2) worst case running time + O(1) memory
////    }
//
//    // follow up: use quick selection algorithm (based on partition method in quicksort)
//    // https://www.geeksforgeeks.org/quickselect-algorithm/
//    // expected algorithm complexity big o n with worst case big o n^2
////    public int findKthLargest(int[] nums, int k) {
////        int start = 0;
////        int end = nums.length - 1;
////        k = nums.length - k;
////        while (start < end) {
////            int i = partition(start, end, nums);
////            if (i < k) {
////                start = i + 1;
////            } else if (i > k) {
////                end = i - 1;
////            } else {
////                break;
////            }
////        }
////        return nums[k];
////    }
////
////    private int partition(int start, int end, int[] arr) {
////        // index [end] set as pivot
////        int pivot = arr[end];
////        int lowerBound = start;
////
////        for (int i = start; i < end; i++) {
////            if (arr[i] <= pivot) {
////                swap(i, lowerBound++, arr);
////            }
////        }
////
////        swap(end, lowerBound, arr);
////        return lowerBound;
////    }
////
////    private void swap(int x, int y, int[] arr) {
////        int tmp = arr[y];
////        arr[y] = arr[x];
////        arr[x] = tmp;
////    }


}
