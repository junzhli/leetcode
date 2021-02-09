package com.leetcode.intersection_of_two_arrays_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashTable1 = createHashTable(nums1);
        // plan A: 5ms
//        HashMap<Integer, Integer> hashTable2 = createHashTable(nums2);

        // plan B: 5ms
        List<Integer> retList = new ArrayList<>();
        for (int num: nums2) {
            if (hashTable1.containsKey(num) && hashTable1.get(num) > 0) {
                retList.add(num);
                hashTable1.put(num, hashTable1.get(num) - 1);
            }
        }

        // plan A: 5ms
//        if (nums1.length <= nums2.length) {
//            Set<Integer> keys = hashTable1.keySet();
//            for (Integer key: keys) {
//                int intersections = Math.min(hashTable1.get(key), hashTable2.getOrDefault(key, 0));
//                fillArr(retList, key, intersections);
//            }
//        } else {
//            Set<Integer> keys = hashTable2.keySet();
//            for (Integer key: keys) {
//                int intersections = Math.min(hashTable2.get(key), hashTable1.getOrDefault(key, 0));
//                fillArr(retList, key, intersections);
//            }
//        }

        return retList.stream().mapToInt(i->i).toArray();
    }

    private HashMap<Integer, Integer> createHashTable(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num: nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        return hashMap;
    }

    private void fillArr(List<Integer> nums, int num, int numbers) {
        for (int i = 0; i < numbers; i++) {
            nums.add(num);
        }
    }

    /**
     * follow up 1. sorted array
     */
//    public int[] intersect(int[] nums1, int[] nums2) {
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//
//        List<Integer> retList = new ArrayList<>();
//        int i = 0, j = 0;
//        while (i < nums1.length && j < nums2.length) {
//            if (nums1[i] == nums2[j]) {
//                retList.add(nums1[i]);
//                i++;
//                j++;
//            } else if (nums1[i] < nums2[j]) {
//                i++;
//            } else { // nums1[i] > nums2[j]
//                j++;
//            }
//        }
//
//        return retList.stream().mapToInt(k->k).toArray();
//    }

    // follow up 2.
    // follow up 3.
    // https://leetcode.com/problems/intersection-of-two-arrays-ii/discuss/439955/JAVA-SOLUTION-%2B-4-FOLLOW-UPS


}
