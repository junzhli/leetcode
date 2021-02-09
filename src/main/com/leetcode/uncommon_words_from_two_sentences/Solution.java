package com.leetcode.uncommon_words_from_two_sentences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        List<String> res = new ArrayList<>();
        check(A, B, res);
        check(B, A, res);
        return res.toArray(new String[res.size()]);
    }

    private void check(String A, String B, List<String> res) {
        String[] wordsA = A.split(" ");
        String[] wordsB = B.split(" ");
        HashSet<String> indexA = new HashSet<>();

        for (String w: wordsA) {
            indexA.add(w);
        }

        HashSet<String> skipped = new HashSet<>();
        for (String w: wordsB) {
            if (res.contains(w)) {
                res.remove(res.indexOf(w));
                skipped.add(w);
                continue;
            }
            if (!indexA.contains(w) && !skipped.contains(w)) {
                res.add(w);
            }
        }


    }
}

