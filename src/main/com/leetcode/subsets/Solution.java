package com.leetcode.subsets;

import java.util.*;

/**
 * https://leetcode.com/problems/subsets/
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        backtrack(ret, new ArrayList<>(), nums, 0);
        return ret;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
        res.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(res, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }

    }

//    private List<List<Integer>> ans;
//
//    public List<List<Integer>> subsets(int[] nums) {
//        if (nums.length <= 1) {
//            List<List<Integer>> ret = arrToList(nums);
//            ret.add(new ArrayList<>());
//            return ret;
//        }
//        HashMap<Integer, Integer> map = genIndex(nums);
////        Arrays.sort(nums);
//        ans = new ArrayList<>();
//
//
//        findAns(nums, map, nums.length);
//        ans.add(new ArrayList<>());
//        return ans;
//    }
//
//    private List<List<Integer>> findAns(int[] nums, HashMap<Integer, Integer> map,  int len) {
//        if (len == 1) {
//            List<List<Integer>> ret = new ArrayList<>();
//            for (int e: nums) {
//                List<Integer> le = new ArrayList<>();
//                List<Integer> le2 = new ArrayList<>();
//                le.add(e);
//                le2.add(e);
//                ret.add(le);
//                ans.add(le2);
//            }
//            return ret;
//        }
//
//        List<List<Integer>> ret = new ArrayList<>();
//        List<List<Integer>> subList = findAns(nums, map, len - 1);
//        for (int i = 0; i < subList.size(); i++) {
//            List<Integer> e = subList.get(i);
//            int lastEIdx = e.size() - 1;
//            for (int j = map.get(e.get(lastEIdx)) + 1; j < nums.length; j++) {
//                List<Integer> e2 = new ArrayList<>(subList.get(i));
//                List<Integer> e22 = new ArrayList<>(subList.get(i));
//                e2.add(nums[j]);
//                e22.add(nums[j]);
//                ret.add(e2);
//                ans.add(e22);
//            }
//        }
//
//        return ret;
//    }
//
//
//    private HashMap<Integer, Integer> genIndex(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
//        return map;
//    }
//
//    private List<List<Integer>> arrToList(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            List<Integer> element = new ArrayList<>();
//            element.add(nums[i]);
//            res.add(element);
//        }
//        return res;
//    }
}
