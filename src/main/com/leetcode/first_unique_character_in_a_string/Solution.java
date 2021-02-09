package com.leetcode.first_unique_character_in_a_string;

import java.util.*;

public class Solution {
    public int firstUniqChar(String s) {
        // 20ms ~ 50ms not efficient enough
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for (int i = s.length() - 1; i >= 0; i--) {
//            int c = s.charAt(i);
//            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
//        }
//
//        int index = 0;
//        for (int c: s.toCharArray()) {
//            if (hashMap.get(c) == 1) {
//                return index;
//            }
//            index++;
//        }
//
//        return -1;

        // assume that every char in s is lowercase letter, 8ms
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    // not working
//    public int firstUniqChar(String s) {
//        LinkedHashMap<Character, Integer> hashMap = new LinkedHashMap<>();
//        char[] arr = s.toCharArray();
//        for (int i = 0; i < arr.length; i++) {
//            char c = arr[i];
//            if (hashMap.containsKey(c)) {
//                hashMap.remove(c);
//            } else {
//                hashMap.put(c, i);
//            }
//        }
//
//        Iterator<Map.Entry<Character, Integer>> it = hashMap.entrySet().iterator();
//        while (it.hasNext()) {
//            return it.next().getValue();
//        }
//
//        return -1;
//    }
}
