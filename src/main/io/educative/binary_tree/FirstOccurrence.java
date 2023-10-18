package io.educative.binary_tree;

/**
 * Explanation#
 *
 * The problem is equivalent to finding the boundary of elements < 3 and elements >= 3. If we apply a filter of arr[i] <= 3, we would get:
 *
 * Now the problem is reduced to finding the first true element in a boolean array. We already know how to do this from the “Finding the Boundary” module.
 *
 * The time complexity is O(log(N))O(log(N)).
 */
public class FirstOccurrence {
    static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length;
        int boundary = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < target) {
                left = mid + 1;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else { // array[mid] = target, note that '=', which it needs to get further checks to get the first occurrence of target element from lefthand
                boundary = mid;
                right = mid - 1;
            }
        }

        return boundary;
    }

    public static void main(String[] args) {
        System.out.println("Find occurrence :" + binarySearch(new int[]{1, 3, 3, 3, 3, 6, 10, 10, 10, 100}, 3));
        System.out.println("Find occurrence :" + binarySearch(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 1));
        System.out.println("Find occurrence :" + binarySearch(new int[]{1, 22, 22, 33, 50, 100, 20000}, 33));
        System.out.println("Find occurrence :" + binarySearch(new int[]{4, 6, 7, 7, 7, 20}, 8));
        System.out.println("Find occurrence :" + binarySearch(new int[]{6, 7, 9, 10, 10, 10, 90}, 10));
        System.out.println("Find occurrence :" + binarySearch(new int[]{4}, 4));
    }
}
