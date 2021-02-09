package com.leetcode.longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
//        int maxSubstring = 0;
//        int maxTmp = 0;
//        Set<Character> charSet = new HashSet<Character>();
//        int startAt = 0;
//        for (int x = 0; x < s.length();) {
//            if (!charSet.contains(s.charAt(x))) {
//                charSet.add(s.charAt(x));
//                maxTmp++;
//                maxSubstring = (maxTmp > maxSubstring) ? maxTmp : maxSubstring;
//                x++;
//            }
//            else {
//                maxTmp = 0;
//                charSet.clear();
//                startAt++;
//                x = startAt;
//            }
//        }
//
//        return maxSubstring;

        // see solution 3. in https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/
        if (s.length() < 2) {
            return s.length();
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();
        int maxLength = 0;

        for (int j = 0, i = 0; j < s.length(); j++) {
            if (hashMap.containsKey(s.charAt(j))) {
                i = Math.max(hashMap.get(s.charAt(j)) + 1, i); // * use Math.max to skip all elements before index i
                // instead of replacing its last-visited index in hashmap with current index
            }
            hashMap.put(s.charAt(j), j);
            maxLength = Math.max(j - i + 1, maxLength);
        }

        return maxLength;
        // time complexity: big o n
        // space complexity: big o n ~ m (min(n, m))
    }
}
