package com.leetcode.four_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {

    /**
     * 4Sum
     *
     * The same concept as three sum
     *
     * h - i - j - k
     *         <--->
     * iterate over numbers array, fix index of h and i when checks if number sum equals, greater than, less then target
     * if equals, add set to hashset
     * if greater than target, decrease k by 1
     * if less than target, increase j by 1
     *
     * note that we improve the calculation time by avoiding duplicate
     *
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> hashSet = new HashSet<>();

        for (int index = 0; index < nums.length - 3; index++) {
            if (index > 0 && nums[index] == nums[index - 1]) { // avoid duplicate (if value at index (previous = current - 1) equals value at index (current)
                continue;
            }

            for (int index2 = index + 1; index2 < nums.length - 2; index2++) {
                if (index2 > index + 1 && nums[index2] == nums[index2 - 1]) { // avoid duplicate (if value at index (previous = current - 1) equals value at index (current)
                    continue;
                }

                int index3 = index2 + 1;
                int index4 = nums.length - 1;
                while (index4 > index3) {
                    if (index4 < nums.length - 1 && nums[index4] == nums[index4 + 1]) { // avoid duplicate (if value at index (previous = current + 1) equals value at index (current)
                        index4--;
                        continue;
                    }

                    int h = nums[index];
                    int i = nums[index2];
                    int j = nums[index3];
                    int k = nums[index4];

                    if (h + i + j + k > target) {
                        index4--;
                    } else if (h + i + j + k < target) {
                        index3++;
                    } else {
                        List<Integer> set = Arrays.asList(nums[index], i , j ,k);

                        if (!hashSet.contains(set)) {
                            res.add(set);
                            hashSet.add(set);
                        }

                        index3++;
                        index4--;
                    }
                }
            }
        }

        return res;
    }

}
