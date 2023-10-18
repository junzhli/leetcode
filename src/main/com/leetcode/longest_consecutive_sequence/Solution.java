package com.leetcode.longest_consecutive_sequence;

import java.util.HashMap;

// https://leetcode.com/problems/longest-consecutive-sequence/description/?envType=featured-list&envId=top-interview-questions
// we are asked to run at t.c. o(n)
// USE MORE SPACE FOR SAKE OF LINEAR RUNNING TIME
public class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> positionMap = new HashMap<>(); // index position of elements in array
        HashMap<Integer,Integer> lastConsecutiveCacheByNumber = new HashMap<>(); // record the last time we calculate for the element
        for (int i = 0; i < nums.length; i++) {
            positionMap.put(nums[i], i);
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            int sub = 0;
            while (positionMap.containsKey(start)) {
                if (lastConsecutiveCacheByNumber.containsKey(start)) {
                    sub += lastConsecutiveCacheByNumber.get(start);
                    max = Math.max(sub, max);
                    break;
                }

                sub++;
                max = Math.max(sub, max);
                start++;
            }
            lastConsecutiveCacheByNumber.put(nums[i], sub);
        }


        return max;
    }
}
