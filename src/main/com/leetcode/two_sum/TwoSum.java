package com.leetcode.two_sum;
import java.util.*;

class Solution {
    /**
     * https://leetcode.com/problems/two-sum/description/
     * @param nums
     * @param target
     * @return int array of ans that sums up {@param nums} to the {@param target}
     */
    // this runs at n^2 time complexity
//    public static int[] twoSum(int[] nums, int target) {
//        int[] ans = {0, 0};
//        for (int x = 0; x < nums.length; x++) {
//            for (int y = x + 1; y < nums.length; y++) {
//                if ((nums[x] + nums[y]) == target) {
//                    ans[0] = x;
//                    ans[1] = y;
//                    return ans;
//                }
//            }
//        }
//        return null;
//    }

    // improve the time complexity to o(n)
    public static int[] twoSum(int[] nums, int target) {
        // create a hashmap to index each position of elements in array
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashmap.put(nums[i], i);
        }

        // get each pair's complement to check whether if it gets a match in hashmap which indicates the answer we expected
        for (int j = 0; j < nums.length; j++) {
            int complement = target - nums[j];
            if (hashmap.containsKey(complement)) {
                return new int[] {j, hashmap.get(complement)};
            }
        }

        throw new IllegalArgumentException("no such solution with thie args");
    }

    public static void main(String[] strings) {
        int[] a = {1, 2, 3, 4};
        int[] res = twoSum(a, 5);
        if (res != null) {
            System.out.println(Arrays.toString(res));
        }
    }
}


