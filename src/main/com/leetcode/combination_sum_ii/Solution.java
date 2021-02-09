package com.leetcode.combination_sum_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
    // similar solution used in combination_sum
    // difference in additional duplicate check and move to next index when recursion
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();
        find(new HashSet<>(), res, candidates, target, new ArrayList<>(), 0);
        return res;
    }

    private void find(HashSet<List<Integer>> hashSet, List<List<Integer>> res, int[] candidates, int target, List<Integer> intermediate, int start) {
        if (target == 0) {
            if (hashSet.contains(intermediate)) {
                return;
            }
            List<Integer> comb = new ArrayList<>(intermediate);
            res.add(comb); // always remember that
            hashSet.add(comb);
            return;
        }

        while (start < candidates.length && target > 0 && target >= candidates[start]) {
            intermediate.add(candidates[start]);
            find(hashSet, res, candidates, target - candidates[start], intermediate, ++start); // !! number in combinations disallow duplicates, so ++start not start++
            intermediate.remove(intermediate.size() - 1);
        }
    }
}
