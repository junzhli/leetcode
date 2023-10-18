package io.educative.two_pointers;

import java.util.Arrays;
import java.util.stream.Collectors;

// t.c. o(n)

/**
 * Problem statement#
 *
 * Given an array of integers, move all the 0s to the back of the array while maintaining the relative order of the non-zero elements. Do this in-place using constant auxiliary space.
 * Example#
 *
 * Input: [1, 0, 2, 0, 0, 7]
 *
 * Output: [1, 2, 7, 0, 0, 0]
 */
public class MoveZeros {
    public static void moveZeros(int[] nums) {
        // WRITE YOUR BRILLIANT CODE HERE
        int lastPosResult = 0;
        int inProcessPos = 0;

        for (; inProcessPos < nums.length; inProcessPos++) {
            if (nums[inProcessPos] != 0) {
                // do swap
                swap(nums, lastPosResult++, inProcessPos);
            }
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args){
        String[] inputs = {"1 0 2 0 0 7", "3 1 0 1 3 8 9"};
        for(int i = 0; i < inputs.length; i++) {
            int[] arr = Arrays.stream(inputs[i].split(" ")).mapToInt(Integer::parseInt).toArray();
            moveZeros(arr);
            System.out.println("Move zero :"+Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
        }
    }
}
