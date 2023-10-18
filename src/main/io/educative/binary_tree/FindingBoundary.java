package io.educative.binary_tree;

import java.util.Comparator;
import java.util.TreeMap;
/**
 * Problem statement#
 *
 * An array of boolean values is divided into two sections: the left section consists of all false, and the right section consists of all true. Find the boundary of the right section, i.e. the index of the first true element. If there is no true element, return -1.
 * Example#
 *
 * Input: arr = [false, false, true, true, true]
 *
 * Output: 2
 *
 * Explanation: first true's index is 2.
 */

/**
 * t.c. log(N)
 */

/**
 * Alternative approach#
 *
 * Another approach to handle case 2 above is to keep the current element in the search range instead of discarding it, i.e. if arr[mid]: right = mid instead of right = mid - 1. However, doing this without modifying the while condition will result in an infinite loop. This is because when left == right, right = mid will not modify right and thus not shrink the search range and we will be stuck in the while loop forever. To make this work, we have to remove the equality in the while condition. In addition, as mentioned in the last module, a while loop without equality will miss the single-element edge case, so we have to add an additional check after the loop to handle this case. Overall, we have to make three modifications to the vanilla binary search to make it work.
 * Side note: how to not get stuck in an infinite loop#
 *
 *     Make progress in each step
 *     Have an exit strategy
 */
public class FindingBoundary {
    static int binarySearch(boolean[] array) {
        int left = 0;
        int right = array.length;
        int boundaryRighthand = -1;

        while(left <= right) { // note that '=' is for case with array.length = 1, otherwise the case will be missed
            if (left == right) {
                return left;
            }

            int mid = (left) + (right - left) / 2;
            if (array[mid]) {
                boundaryRighthand = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return boundaryRighthand;
    }

    public static void main(String[] args) {
        System.out.println("Find boundry :" + binarySearch(new boolean[]{false, false, true, true, true}));
        System.out.println("Find boundry :" + binarySearch(new boolean[]{true}));
        System.out.println("Find boundry :" + binarySearch(new boolean[]{false, false, false}));
        System.out.println("Find boundry :" + binarySearch(new boolean[]{true, true, true, true, true}));
        System.out.println("Find boundry :" + binarySearch(new boolean[]{false, true}));
    }
}
