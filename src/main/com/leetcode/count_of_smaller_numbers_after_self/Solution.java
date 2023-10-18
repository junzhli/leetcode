package com.leetcode.count_of_smaller_numbers_after_self;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/?envType=featured-list&envId=top-interview-questions
// https://leetcode.com/problems/count-of-smaller-numbers-after-self/solutions/445769/merge-sort-clear-simple-explanation-with-examples-o-n-lg-n/?envType=featured-list&envId=top-interview-questions
// t.c. o(n log(n))
// t.c. o(n)
class Solution {
    class IntegerWithIndex {
        int val;
        int index;

        IntegerWithIndex(int val, int index) {
            this.val = val;
            this.index = index; // denotes the original position of 'nums' // we'll loss the position data during merge ops
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int[] counts = new int[nums.length];
        IntegerWithIndex[] wrappedNums = buildValWithIndexInstances(nums);
        IntegerWithIndex[] res = mergeSort(wrappedNums, 0, nums.length - 1, counts);
        ArrayList<Integer> resAsList = new ArrayList<>();
        for (int c: counts) {
            resAsList.add(c);
        }
        
        return resAsList;
    }

    private IntegerWithIndex[] buildValWithIndexInstances(int[] nums) {
        IntegerWithIndex[] res = new IntegerWithIndex[nums.length];
        for(int i = 0; i < nums.length; i++) {
            res[i] = new IntegerWithIndex(nums[i], i);
        }
        return res;
    }

    private IntegerWithIndex[] mergeSort(IntegerWithIndex[] nums, int start, int end, int[] counts) {
        if (start > end) {
            return new IntegerWithIndex[0];
        }

        if (nums.length < 2) {
            return nums;
        }

        int mid = 0 + (nums.length - 1) / 2;
        IntegerWithIndex[] leftArr = split(nums, 0, mid);
        IntegerWithIndex[] rightArr = split(nums, mid + 1, nums.length - 1);
        int lStart = start;
        int lEnd = start + mid;
        int rStart = lEnd + 1;
        int rEnd = end;
        return sort(mergeSort(leftArr, lStart, lEnd, counts), lStart, lEnd, mergeSort(rightArr, rStart, rEnd, counts), rStart, rEnd, counts);
    }

    private IntegerWithIndex[] split(IntegerWithIndex[] arr, int start, int end) {
        IntegerWithIndex[] res = new IntegerWithIndex[end - start + 1];
        int cursor = start;
        for (int i  = 0; i < res.length; i++) {
            res[i] = arr[cursor++];
        }
        return res;
    }

    private IntegerWithIndex[] sort(IntegerWithIndex[] leftArr, int lStart, int lEnd, IntegerWithIndex[] rightArr, int rStart, int rEnd, int[] counts) {
        int newLen = rEnd - lStart + 1;
        IntegerWithIndex[] newArr = new IntegerWithIndex[newLen];
        int cursor = 0;
        int lCursor = 0;
        int rCursor = 0;
        int numberOfRightElementsMoved = 0;
        while (lCursor < leftArr.length && rCursor < rightArr.length) {
            if (leftArr[lCursor].val > rightArr[rCursor].val) {
                newArr[cursor++] = rightArr[rCursor++];
                numberOfRightElementsMoved++; // !! keep track of currently moved right items that smaller than left items
                // we suppose that left arr and right arr are self sorted, which means we can use this approach to keep track number of items that is smaller than the left item one counting up all items smaller than itself
            } else {
                counts[leftArr[lCursor].index] += numberOfRightElementsMoved; // !! just increment by this at once
                newArr[cursor++] = leftArr[lCursor++];
            }
        }

        while (rCursor < rightArr.length) {
            newArr[cursor++] = rightArr[rCursor++];
        }

        while (lCursor < leftArr.length) {
            counts[leftArr[lCursor].index] += numberOfRightElementsMoved;
            newArr[cursor++] = leftArr[lCursor++];
        }

        return newArr;
    }
}
