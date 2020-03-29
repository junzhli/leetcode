package com.leetcode.palindrome_partitioning;

import utils.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, Boolean> cache = new HashMap<>();
        buildResult(s, res, cache, 0, new ArrayList<>());
        return res;
    }

    private void buildResult(String s, List<List<String>> res, HashMap<String, Boolean> cache, int startIndex, List<String> sol) {
        if (startIndex == s.length()) {
            res.add(sol);
            return;
        }

//        for (int i = startIndex; i < s.length(); i++) {
        for (int j = startIndex + 1; j <= s.length(); j++) {
            String subS = s.substring(startIndex, j);
            if (isPalindrome(cache, subS)) {
                sol.add(subS);
                buildResult(s, res, cache, j, new ArrayList<>(sol));
                sol.remove(sol.size() - 1);
            }
        }
//        }
    }

    private boolean isPalindrome(HashMap<String, Boolean> cache, String s) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }

        int x = 0;
        int y = s.length() - 1;
        while (x <= y) {
            if (s.charAt(x) != s.charAt(y)) {
                cache.put(s, false);
                return false;
            }
            x++;
            y--;
        }
        cache.put(s, true);
        return true;
    }
}
