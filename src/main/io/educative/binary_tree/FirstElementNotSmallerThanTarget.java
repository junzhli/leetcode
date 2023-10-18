package io.educative.binary_tree;

/**
 * Problem statement#
 *
 * Given an array of integers sorted in increasing order and a target, find the index of the first element in the array that is larger or equal to the target. Assume that it is guaranteed to find a satisfying number.
 * Example#
 *
 * Input: arr = [1, 3, 3, 5, 8, 8, 10],target = 2
 *
 * Output: 1
 *
 * Explanation: the first element larger than 2 is 3, which has index 1.
 */
public class FirstElementNotSmallerThanTarget {
//    static int binarySearch(int[] array, int target) {
//        int left = 0;
//        int right = array.length;
//        int boundary = -1;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (array[mid] < target) {
//                left = mid + 1;
//            } else {
//                boundary = mid;
//                right = mid - 1;
//            }
//        }
//
//        return boundary;
//    }

    static int binarySearch(int[] array, int target) {
        if (array.length == 0) {
            return -1;
        }

        if (array.length == 1) { //**
            if (array[0] < target) {
                return -1;
            } else {
                return 0;
            }
        }

        int left = 0;
        int right = array.length;
        int boundary = -1;
        while (left < right) { //**
            int mid = left + (right - left) / 2;
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                boundary = mid;
                right = mid; //**
            }
        }

        return boundary;
    }

    public static void main(String[] args) {
        System.out.println("Find first element :" + binarySearch(new int[]{1, 3, 3, 5, 8, 8, 10}, 2));
        System.out.println("Find first element :" + binarySearch(new int[]{0}, 0));
        System.out.println("Find first element :" + binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10));
        System.out.println("Find first element :" + binarySearch(new int[]{1, 1, 1, 1, 4, 5}, 3));
    }
}
