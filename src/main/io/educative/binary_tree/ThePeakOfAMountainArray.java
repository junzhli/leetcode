package io.educative.binary_tree;

/**
 * A mountain array is defined as an array that:
 *
 *     Has at least 3 elements.
 *     Has an element with the largest value called the “peak”, at an index k. The array elements monotonically increase from the first element to A[k], and then monotonically decreases from A[k + 1] to the last element of the array. Thus creating a “mountain” of numbers.
 *
 * Find the index of the peak element. Assume there are no duplicates.
 * Example#
 *
 * Input: 0 1 2 3 2 1 0
 *
 * Output: 3
 *
 * Explanation: The largest element is 3 and its index is 3.
 */
public class ThePeakOfAMountainArray {
    static int binarySearch(int[] array) {
        int left = 0;
        int right = array.length;
        int boundary = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == array.length - 1 || array[mid] > array[mid + 1]) {
                boundary = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return boundary;
    }

    public static void main(String[] args) {
        System.out.println("Find peak of mountain :" + binarySearch(new int[]{0, 1, 2, 3, 2, 1, 0}));
        System.out.println("Find peak of mountain :" + binarySearch(new int[]{0, 10, 3, 2, 1, 2}));
        System.out.println("Find peak of mountain :" + binarySearch(new int[]{0, 10, 0}));
    }
}
