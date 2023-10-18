package com.leetcode.first_missing_positive;

// https://leetcode.com/problems/first-missing-positive/submissions/964913184/
// we are asked to reduce t.c. and s.c. to o(n) and o(1) respectively
public class Solution {
    public int firstMissingPositive(int[] nums) {
        // idea behind this is to move existing element where 1 <= n <= length of nums + 1 to position n, i.e. nums[i] = i + 1 in the first place
        // put the original value at position i to current cursor (see IMPORTANT note)
        // rest of them which don't meet the condition will be ignored
        // and then we will loop from index 0 and stop if the element is not equal to element + 1, where it is located at index element
        for (int i = 0; i < nums.length;) {
            if (nums[i] >= 1 && nums[i] <= nums.length) {
                if (nums[i] != i + 1) {
                    int tmp = nums[i];
                    int tmp2 = nums[tmp - 1];
                    nums[tmp - 1] = tmp;
                    // IMPORTANT: we have to handle this case where it causes infinite loop when swapping element
                    if (tmp2 == nums[i]) {
                        nums[i] = Integer.MIN_VALUE;
                    } else {
                        nums[i] = tmp2;
                    }
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i+1;
            }
        }

        return nums.length + 1;
    }
}
