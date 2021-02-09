package com.leetcode.wiggle_sort_ii;

import java.util.Arrays;
import java.util.Random;

public class Solution {
    // airbnb
    // this arr contains duplicate elements, not distinct as compared to wiggle sort
    // big o N * logN
    //
    // https://www.cnblogs.com/grandyang/p/5139057.html
    // 這道題給了我們一個無序數組，讓我們排序成擺動數組
    //，滿足nums[0] < nums[1] > nums[2] < nums[3]...，並給了我們例子。
    //我們可以先給數組排序，然後在做調整。調整的方法是找到數組的中間的數，相當於把有序數組從中間分成兩部分，
    //然後從前半段的末尾取一個，在從後半的末尾去一個，
    //這樣保證了第一個數小於第二個數，然後從前半段取倒數第二個，
    //從後半段取倒數第二個，這保證了第二個數大於第三個數，
    //且第三個數小於第四個數，以此類推直至都取完，參見代碼如下：
    //
    //
    //

    // the best explanation ever:
    // https://leetcode.com/problems/wiggle-sort-ii/discuss/77684/summary-of-the-various-solutions-to-wiggle-sort-for-your-reference/81858
// round 1
// t.c. o(nlog(n)) s.c. o(n)
//    public void wiggleSort(int[] nums) {
//        if (nums.length < 2) {
//            return;
//        }
//
//        int upper = nums.length - 1;
//        int lower = (nums.length - 1) / 2; // even size: . (lower) . (upper) | odd size: . (lower) . . (upper)
//        int[] tmpArr = Arrays.copyOf(nums, nums.length);
//        Arrays.sort(tmpArr);
//
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = (i % 2 == 0) ? tmpArr[lower--] : tmpArr[upper--];
//        }
//    }

    // round 2 t.c. o(n) s.c. o(n)
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = nums.length - 1;
        int mid = start + (end - start) / 2;
        int[] copy = Arrays.copyOf(nums, nums.length);

        int median = findKthSmallest(copy, mid); // it actually includes several partitions but it is not enough

        // this partition is required as it needs to handle some cases for median duplicates (e.g. 1,2,3,5,5,5,6,7,8)
        for (int i = 0, j = 0, k = n - 1; j <= k;) {
             if (copy[j] < median) {
                 swap(copy, i++, j++);
             } else if (copy[j] > median) {
                 swap(copy, j, k--);
             } else {
                 j++;
             }
         }

//        for (int co: copy) {
//            System.out.println(co);
//        }

        int low = mid; // !!!! from higher index of its lefthand array
        int high = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = copy[low--];
            } else {
                nums[i] = copy[high--];
            }
        }
    }

    private int findKthSmallest(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        int mid = -1;

        while (start <= end) {
            mid = partition(nums, start, end);

            if (mid < k) {
                start = mid + 1;
            } else if (mid > k) {
                end = mid - 1;
            } else {
                break;
            }
        }

        return nums[mid];
    }

    private int partition(int[] nums, int start, int end) {
        int medium = nums[end];

        int i = start;
        int j = start;
        while(j < end) {
            if (nums[j] < medium) {
                swap(nums, i++, j);
            }
            j++;
        }
        swap(nums, end, i);

        return i;
    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[y];
        nums[y] = nums[x];
        nums[x] = tmp;
    }
}
