package io.educative.binary_tree;

public class SquareRoot {
    static int binarySearch(int target) {
        if (target < 0) {
            return -1;
        }

        if (target == 0) {
            return 0;
        }

//        int[] array = new int[target/2 + 1];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = i + 1; // fill value starting from 1
//        }
        // note that we can represent the idea without array, as index = value = 1....n

        int left = 0;
        int right = target / 2;
        int boundary = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid <= target) {
                boundary = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return boundary;
    }

    public static void main(String[] args) {
        System.out.println("Square root :" + binarySearch(4));
        System.out.println("Square root :" + binarySearch(8));
        System.out.println("Square root :" + binarySearch(100000));
    }
}
