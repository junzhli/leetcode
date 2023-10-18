package com.leetcode.contains_duplicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Solution {
    // use hashset by well known data structure: 6ms
    // ** hashset costs in a constant time (insert/get/contains)
//    public boolean containsDuplicate(int[] nums) {
//        HashSet<Integer> hashTable = new HashSet<>();
//        for (int n: nums) {
//            if (hashTable.contains(n)) {
//                return true;
//            }
//            hashTable.add(n);
//        }
//        return false;
//    }

    // by iteration with sorted array: 3ms
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

//    private static volatile boolean initialized = false;
//    public static void main(String[] args) {
//        var rwLock = new ReentrantReadWriteLock();
//        System.out.println(rwLock);
//        rwLock.writeLock().lock();
//        rwLock.readLock().lock();
//    }
}
