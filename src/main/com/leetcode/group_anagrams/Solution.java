package com.leetcode.group_anagrams;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> hashMap = new HashMap<>();

        if (strs.length == 0) {
            return res;
        }

        for (String x: strs) {
            char[] arr = x.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if (hashMap.containsKey(key)) {
                // existing
                List<String> value = hashMap.get(key);
                value.add(x);

            } else {
                // new
                List<String> value = new ArrayList<>();
                value.add(x);
                hashMap.put(key, value);
            }
        }

        for (String key: hashMap.keySet()) {
            res.add(hashMap.get(key));
        }

        return res;
    }
}
