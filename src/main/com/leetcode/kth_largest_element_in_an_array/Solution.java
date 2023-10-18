package com.leetcode.kth_largest_element_in_an_array;

import java.util.Arrays;
import java.util.HashSet;

// https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/60294/Solution-explained
public class Solution {
    // round 4
    // same as round 2, beautifier
    public int findKthLargest(int[] nums, int k) {
        // use quick select algorithm, which it originates from quick select's subprocedure 'partition'
        int res = -1;
        int start = 0;
        int end = nums.length - 1;
        k = nums.length - k; // nth largest -- indicates --> index (length - n) e.g. 1th --> len = 3 --> 3 - 1 = 2 index
        while (start <= end) {
            res = partition(nums, start, end);
            if (res == k) {
                return nums[k];
            } else if (res < k) {
                start = res + 1;
            } else { // res > k
                end = res - 1;
            }
        }
        return -1;
    }

    private int partition(int[] nums, int start, int end) {
        if (start == end) {
            return start;
        }
        int pivot = nums[end]; // always choose end index
        int i = start;
        for (int j = start; j <= end - 1; j++) {
            if (nums[j] <= pivot) {
                swap(i, j, nums);
                i++;
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

    // not working, leads to tle
//    public int findKthLargest(int[] nums, int k) {
//        HashSet<Integer> set = new HashSet<>();
//        int gMax = Integer.MAX_VALUE;
//        int pos = -1;
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < k; i++) {
//            max = Integer.MIN_VALUE;
//            pos = -1;
//
//            for (int j = 0; j < nums.length; j++) {
//                if (nums[j] <= gMax && !set.contains(j)) {
//                    if (nums[j] >= max) {
//                        max = nums[j];
//                        pos = j;
//                    }
//                }
//            }
//            gMax = max;
//            set.add(pos);
//        }
//        return gMax;
//    }

    // round 2
    // quick select algorithm
    // t.c. avg o(n), worst o(n^2), ... n + n/2 + n/4 .... < 2n
    // s.c. o(1)
//    public int findKthLargest(int[] nums, int k) {
//        int start = 0;
//        int end = nums.length - 1;
//        k = (nums.length - k);
//        while (start <= end) { // why <=, rather than <: for case of array with length 1. e.g. [1]
//            int pivot = partition(nums, start, end);
//            if (pivot < k) {
//                start = pivot + 1;
//            } else if (pivot > k) {
//                end = pivot - 1;
//            } else {
//                return nums[pivot];
//            }
//        }
//        return -1;
//    }
//
//    private int partition(int[] nums, int start, int end) {
//        int pivot = nums[end];
//
//        int i = start; // denotes lower bound
//        int j = start; // denotes current index of looping array
//        for (; j < end; j++) {
//            if (nums[j] <= pivot) {
//                swap(i++, j, nums);
//            }
//        }
//
//        swap(i, end, nums);
//        return i;
//    }
//
//    private void swap(int x, int y, int[] nums) {
//        int tmp = nums[x];
//        nums[x] = nums[y];
//        nums[y] = tmp;
//    }

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
