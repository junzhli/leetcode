package com.leetcode.combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 */
public class Solution {
    // round 2
    // time complexity:
    // space complexity:
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();
        find(res, candidates, target, new ArrayList<>(), 0);
        return res;
    }

    private void find(List<List<Integer>> res, int[] candidates, int target, List<Integer> intermediate, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(intermediate)); // always remember that
            return;
        }

        while (start < candidates.length && target > 0 && target >= candidates[start]) {
            intermediate.add(candidates[start]);
            find(res, candidates, target - candidates[start], intermediate, start++); // !! number in combinations allow duplicates, so start not ++start
            intermediate.remove(intermediate.size() - 1);

        }
    }

    // round 1
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        // sort array in ascending order (1,2,3,4...)
//        Arrays.sort(candidates);
//        List<List<Integer>> res = new ArrayList<>(); // result
//
//        /**
//         * get it solved with backtracking algorithm which select and evaluate all unique combinations:
//         * stop if target equals zero
//         */
//        findCombination(candidates, target, res, new ArrayList<>(), 0);
//        return res;
//    }
//
//    private void findCombination(int[] candidates, int target, List<List<Integer>> res, List<Integer> candidate, int start) {
//        if (target == 0) {
//            res.add(new ArrayList<>(candidate)); // !important
//            return;
//        }
//
//        if (target > 0) {
//            for (; start < candidates.length && target >= candidates[start]; start++) {
//                candidate.add(candidates[start]); // add it first
//                findCombination(candidates, target - candidates[start], res, candidate, start); // evaluate
//                candidate.remove(candidate.size() - 1); // remove it if not meets the demand
//            }
//        }
//    }
}
