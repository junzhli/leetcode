package io.educative.binary_tree;

/**
 * A sorted array was rotated at an unknown pivot. For example, [10, 20, 30, 40, 50] becomes [30, 40, 50, 10, 20]. Find the index of the minimum element in this array.
 * Example#
 *
 * Input: [30, 40, 50, 10, 20]
 *
 * Output: 3
 *
 * Explanation: The smallest element is 10 and its index is 3.
 */
public class FindMinimumInRotatedSortedArray {
//    static int binarySearch(int[] array) {
//        int left = 0;
//        int right = array.length - 1;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (array[mid] > array[right]) {
//                left = mid + 1; // answer would be in range of mid + 1 ~ right
//            } else {
//                right = mid;
//            }
//        }
//
//        return left;
//    }

    static int binarySearch(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int boundary = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > array[array.length - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
                boundary = mid;
            }
        }

        return boundary;
    }

    public static void main(String[] args) {
        System.out.println("Find minimum rotated :" + binarySearch(new int[]{30, 40, 50, 10, 20}));
        System.out.println("Find minimum rotated :" + binarySearch(new int[]{0, 1, 2, 3, 4, 5}));
        System.out.println("Find minimum rotated :" + binarySearch(new int[]{0}));
    }
}
