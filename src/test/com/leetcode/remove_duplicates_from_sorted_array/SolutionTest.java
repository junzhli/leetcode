package com.leetcode.remove_duplicates_from_sorted_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void removeDuplicates() {
        Solution sol = new Solution();
        int[] test1 = new int[]{0,0,1,1,1,2,2,3,3,4,5,6,7,8,9};
        int res1 = sol.removeDuplicates(test1);
        print(res1, test1);
    }

    private void print(int length, int[] arr) {
        for (int x = 0; x < length; x++) {
            System.out.println(arr[x]);
        }
    }
}