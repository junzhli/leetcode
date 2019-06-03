package com.leetcode.twosum;
import java.util.Arrays;

class Solution {
    /**
     * https://leetcode.com/problems/two-sum/description/
     * @param nums
     * @param target
     * @return int array of ans that sums up {@param nums} to the {@param target}
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] ans = {0, 0};
        for (int x = 0; x < nums.length; x++) {
            for (int y = x + 1; y < nums.length; y++) {
                if ((nums[x] + nums[y]) == target) {
                    ans[0] = x;
                    ans[1] = y;
                    return ans;
                }
            }
        }
        return null;
    }

    public static void main(String[] strings) {
        int[] a = {1, 2, 3, 4};
        int[] res = twoSum(a, 5);
        if (res != null) {
            System.out.println(Arrays.toString(res));
        }
    }
}


