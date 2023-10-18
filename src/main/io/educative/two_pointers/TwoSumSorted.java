package io.educative.two_pointers;

/**
 * Given an array of integers sorted in ascending order, find two numbers that add up to a given target. Return the indices of the two numbers in ascending order. You can assume elements in the array are unique and that there is only one solution. Do this in O(n) time and with constant auxiliary space.
 * Example#
 *
 * Input: [2, 3, 4, 5, 8, 11, 18], 8
 *
 * Output: 1 3
 */
// o(n)
public class TwoSumSorted {
    public static int[] twoSumSorted(int[] arr, int target) {
        // WRITE YOUR BRILLIANT CODE HERE
        int leftPos = 0;
        int rightPos = arr.length - 1;

        while (leftPos < rightPos) {
            if (arr[leftPos] + arr[rightPos] == target) {
                break;
            } else if (arr[leftPos] + arr[rightPos] < target) {
                leftPos++;
            } else {
                rightPos--;
            }
        }

        int[] res = {leftPos, rightPos};
        return res;
    }
}
