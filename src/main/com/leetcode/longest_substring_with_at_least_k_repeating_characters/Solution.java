package com.leetcode.longest_substring_with_at_least_k_repeating_characters;

public class Solution {
    // recursion (divide big problem into multiple small problems)
    // 时间复杂度是 O(n),  递归每层是 O(n), 最多删除 26 个字母, 递归 26 层, O(26*n) = O(n)
    // https://www.youtube.com/watch?v=GU-03VY12Ic
    // https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/discuss/87738/Java-20-lines-very-easy-solution-7ms-with-explanation
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // get freq of every chars in substring
        int[] freq = new int[26];
        for (int c: s.toCharArray()) {
            freq[c - 'a'] += 1;
        }

        // check if the substring as a whole is what we want to return
        boolean valid = true;
        for (int f: freq) {
            if (f > 0 && f < k) {
                valid = false;
            }
        }
        if (valid) {
            return s.length();
        }

        // !!! important part: when its freq of end char in substring is less than expected k
        // we divide this into two part, looking like this <-Asub--> <skipped char> <-Bsub->
        // uses recursion to check Asub and Bsub
        int start = 0;
        int end = 0;
        int result = 0;
        while (end < s.length()) {
            // if char at the end freq is not greater than k, it fallbacks to get result from str starting from
            // start to end - 1 as the current result if it is greater than current one.
            // and than it start from end + 1
            if (freq[s.charAt(end) - 'a'] < k) {
                // jump here to calculate result for str from start to end - 1, and then skip the one not fitting into need
                // start from end + 1
                result = Math.max(result, longestSubstring(s.substring(start, end), k));
                start = end + 1;
            }

            // keep letting end move right if char freq fits into the demand
            end += 1;
        }
        result = Math.max(result, longestSubstring(s.substring(start, end), k)); // call it again, otherwise we'll miss the rest of part substring from start ± end

        return result;
    }

    /**
     * Another example of implementation based upon divide and conquer
     */
//    public int longestSubstring(String s, int k) {
//        char[] str = s.toCharArray();
//        return helper(str,0,s.length(),k);
//    }
//    private int helper(char[] str, int start, int end,  int k){
//        if (end - start < k) return 0;//substring length shorter than k.
//        int[] count = new int [26];
//        for (int i = start; i<end; i++) {
//            int idx = str[i] - 'a';
//            count[idx]++;
//        }
//        for (int i=0; i<26; i++) {
//            if (count[i] < k && count[i] > 0) { //count[i]=0 => i+'a' does not exist in the string, skip it.
//                for (int j = start; j<end; j++) {
//                    if (str[j] == i+'a') {
//                        int left = helper(str, start, j, k);
//                        int right = helper(str, j+1, end, k);
//                        return Math.max(left, right);
//                    }
//                }
//            }
//        }
//        return end - start;
//    }
}
