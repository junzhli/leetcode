package com.leetcode.longest_substring_with_at_most_k_distinct_characters;

import utils.Array;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * https://www.lintcode.com/en/old/problem/longest-substring-with-at-most-k-distinct-characters/
 */

/**
 * Sliding window
 */
public class Solution {
    // round 2
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }

        // write your code here
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        int right = 0;
        while(right < s.length()) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (left < right && map.size() > k) {
                char leftC = s.charAt(left++);
                map.put(leftC, map.get(leftC) - 1);
                if (map.get(leftC) == 0) {
                    map.remove(leftC);
                }
            }

            max = Math.max(max, right - left + 1);

            right++;
        }
        return max;
    }

    // round 1
//    // Given a string S, find the length of the longest substring T that contains at most k distinct characters.
//    /**
//     *  Example
//     *
//     * Example 1:
//     *
//     * Input: S = "eceba" and k = 3
//     * Output: 4
//     * Explanation: T = "eceb"
//     *
//     * Example 2:
//     *
//     * Input: S = "WORLD" and k = 4
//     * Output: 4
//     * Explanation: T = "WORL" or "ORLD"
//     *
//     * Run this with O(n) time
//     */
//    public int lengthOfLongestSubstringKDistinct(String s, int k) {
//        int res = 0;
//        HashMap<Character, Integer> hashMap = new HashMap<>();
//
//        int i = 0;
//        for (int j = i; j < s.length(); j++) {
//            char c = s.charAt(j);
//            addCharFromHashMap(c, hashMap);
//
//            while (hashMap.keySet().size() > k) {
//                char lastChar = s.charAt(i);
//                removeCharFromHashMap(lastChar, hashMap);
//                i++;
//            }
//
//            res = Math.max(j - i + 1, res);
//        }
//
//        return res;
//    }
//
//    private void removeCharFromHashMap(char c, HashMap<Character, Integer> hashMap) {
//        if (!hashMap.containsKey(c)) {
//            return;
//        }
//
//        if (hashMap.get(c) == 1) {
//            hashMap.remove(c);
//            return;
//        }
//
//        hashMap.put(c, hashMap.get(c) - 1);
//    }
//
//    private void addCharFromHashMap(char c, HashMap<Character, Integer> hashMap) {
//        if (!hashMap.containsKey(c)) {
//            hashMap.put(c, 1);
//            return;
//        }
//
//        hashMap.put(c, hashMap.get(c) + 1);
//    }
}
