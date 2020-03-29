package com.leetcode.permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        _permute(nums, new ArrayList<>(), res);
        return res;
    }

    private void _permute(int[] nums, List<Integer> tmpList, List<List<Integer>> res) {
        if (tmpList.size() == nums.length) {
            res.add(new ArrayList<>(tmpList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (tmpList.contains(nums[i])) {
                continue;
            }
            tmpList.add(nums[i]); // add possible step
            _permute(nums, tmpList, res); // recursively find possible step
            tmpList.remove(tmpList.size() - 1); // step back to continue to try next possible stop
        }
    }
}
