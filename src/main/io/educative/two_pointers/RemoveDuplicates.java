package io.educative.two_pointers;

// o (n)
//

/**
 * Problem statement#
 *
 * Given a sorted list of numbers, remove duplicates and return the new length. You must do this in-place and without using extra memory.
 *
 * Input: [0, 0, 1, 1, 1, 2, 2]
 *
 * Your function should modify the list in-place so the first 3 elements become [0, 1, 2].
 * Example#
 *
 * Input: [0, 0, 1, 1, 1, 2, 2]
 *
 * Output: 3
 *
 * After modifying the array in place, the array becomes [0, 1, 2, 1, 1, 2, 2] and we return the new length without duplicate 3.
 */
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        // WRITE YOUR BRILLIANT CODE HERE
        int last = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[last] == nums[i]) {
                continue;
            }
            nums[++last] = nums[i];
        }
        return last + 1;
    }

    public static void main(String[] args) {

    }
}
