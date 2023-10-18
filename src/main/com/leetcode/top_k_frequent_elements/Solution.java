package com.leetcode.top_k_frequent_elements;

import java.util.*;

public class Solution {
    // round 2
    // use quick select algorithm --> hint kth sth.
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int[] elements = new int[map.size()];
        int i = 0;
        for (int key: map.keySet()) {
            elements[i++] = key;
        }


        int n = elements.length - k;
        int start = 0;
        int end = elements.length - 1;
        int pivot = -1;
        while (start <= end) {
            pivot = partition(elements, start, end, map);
            if (pivot < n) {
                start = pivot + 1;
            } else if (pivot > n) {
                end = pivot - 1;
            } else {
                break;
            }
        }

        int[] res = Arrays.copyOfRange(elements, pivot, elements.length);
        return res;
    }

    private int partition(int[] nums, int start, int end, HashMap<Integer, Integer> map) {
        int pivot = end;

        int stored = start;
        for (int i = start; i < end; i++) {
            if (map.get(nums[i]) < map.get(nums[pivot])) {
                swap(nums, stored++, i);
            }
        }
        swap(nums, stored, pivot);
        return stored;
    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    // round 1
    // very straightforward
//    public int[] topKFrequent(int[] nums, int k) {
//        // count the times of each element presented in array
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for (int num: nums) {
//            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
//        }
//
//        // 10ms
////        Comparator<Integer> comparator = (o1, o2) -> hashMap.get(o2) - hashMap.get(o1);
////        PriorityQueue<Integer> pQueue = new PriorityQueue<>(comparator);
////
////        Set<Integer> keySet = hashMap.keySet();
////        for (Integer key: keySet) {
////            pQueue.add(key);
////        }
////
////        int[] res = new int[k];
////        for (int i = 0; i < res.length; i++) {
////            res[i] = pQueue.poll();
////        }
////
////        return res;
//
//        // 7ms
//        // use bucket to represent how frequencies of each element in array are
//        List<Integer>[] bucket = new ArrayList[nums.length + 1];
//        Set<Integer> keySet = hashMap.keySet();
//        for (Integer key: keySet) {
//            int frequency = hashMap.get(key);
//            if (bucket[frequency] == null) {
//                bucket[frequency] = new ArrayList<>();
//            }
//            bucket[frequency].add(key);
//        }
//
//        // iterate from last index through bucket to get top k frequent elements
//        int[] res = new int[k];
//        for (int i = bucket.length - 1, count = 0; i >= 0 && count < res.length; i--) {
//            if (bucket[i] == null) {
//                continue;
//            }
//
//            for (int key: bucket[i]) {
//                res[count++] = key;
//                if (count >= k) {
//                    break;
//                }
//            }
//        }
//
//        return res;
//    }
}
