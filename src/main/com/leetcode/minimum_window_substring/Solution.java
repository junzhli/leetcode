package com.leetcode.minimum_window_substring;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/minimum-window-substring/description/?envType=featured-list&envId=top-interview-questions
// t.c. o(Math.max(t.length, s.length))
// s.c. o(t.length)
public class Solution {
    // sliding window approach
    public String minWindow(String s, String t) {
        // calculate number of characters in string
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int matched = map.size();
        int start = 0;
        int minStart = 0;
        int minLength = Integer.MAX_VALUE;

        for (int end = 0; end < s.length(); end++) {
            Character c = s.charAt(end);
            if (map.containsKey(c)) { // we only care those chars in t
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    matched--; // keep track of matched chars in t, until we find an possible ans, which matched = 0
                }
            }

            

            while (start <= end && matched == 0) { // we only shift right our starting pos when there's a possible answer
                if (matched == 0) {
                    int len = end - start + 1;
                    if (minLength > len) {
                        minLength = len;
                        minStart = start;
                    }
                }

                Character c2 = s.charAt(start);
                if (map.containsKey(c2)) {
                    map.put(c2, map.get(c2) + 1);
                    if (map.get(c2) > 0) { // as we shift right our starting pos, we are gonna offset what we have calculated for matched number
                        matched++;
                    }
                }
                start++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
}
