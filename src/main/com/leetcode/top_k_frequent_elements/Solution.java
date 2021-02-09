package com.leetcode.top_k_frequent_elements;

import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // count the times of each element presented in array
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num: nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        // 10ms
//        Comparator<Integer> comparator = (o1, o2) -> hashMap.get(o2) - hashMap.get(o1);
//        PriorityQueue<Integer> pQueue = new PriorityQueue<>(comparator);
//
//        Set<Integer> keySet = hashMap.keySet();
//        for (Integer key: keySet) {
//            pQueue.add(key);
//        }
//
//        int[] res = new int[k];
//        for (int i = 0; i < res.length; i++) {
//            res[i] = pQueue.poll();
//        }
//
//        return res;

        // 7ms
        // use bucket to represent how frequencies of each element in array are
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        Set<Integer> keySet = hashMap.keySet();
        for (Integer key: keySet) {
            int frequency = hashMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        // iterate from last index through bucket to get top k frequent elements
        int[] res = new int[k];
        for (int i = bucket.length - 1, count = 0; i >= 0 && count < res.length; i--) {
            if (bucket[i] == null) {
                continue;
            }

            for (int key: bucket[i]) {
                res[count++] = key;
                if (count >= k) {
                    break;
                }
            }
        }

        return res;
    }
}
