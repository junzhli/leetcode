package com.leetcode.longestsubstringwithoutrepeatingcharacters;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxSubstring = 0;
        int maxTmp = 0;
        Set<Character> charSet = new HashSet<Character>();
        int startAt = 0;
        for (int x = 0; x < s.length();) {
            if (!charSet.contains(s.charAt(x))) {
                charSet.add(s.charAt(x));
                maxTmp++;
                maxSubstring = (maxTmp > maxSubstring) ? maxTmp : maxSubstring;
                x++;
            }
            else {
                maxTmp = 0;
                charSet.clear();
                startAt++;
                x = startAt;
            }
        }

        return maxSubstring;
    }
}
