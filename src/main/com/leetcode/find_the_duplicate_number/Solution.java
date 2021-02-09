package com.leetcode.find_the_duplicate_number;

public class Solution {
    // 1,2,3,4,5
    // 1,2,3,1,2
    // https://leetcode.com/problems/find-the-duplicate-number/discuss/72906/JAVA-Easy-Version-To-UnderStand!!!!!!!!!
    // https://yayaya6d.pixnet.net/blog/post/350010631-leetcode%E8%A8%98%E9%8C%84--287.-find-the-duplicate-number
    // https://www.shangmayuan.com/a/9912c089a1354bb995d080d4.html
    // solution: set, t.c. (n)
    // https://leetcode.com/problems/find-the-duplicate-number/discuss/72846/My-easy-understood-solution-with-O(n)-time-and-O(1)-space-without-modifying-the-array.-With-clear-explanation./75491
    // (the best solution ever: use Floyd's Tortoise and hare algorithm), o (n), o(n)

    // t.c. nlogn
    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length - 1;
        int mid = 0;

        while (low < high) {
            mid = Math.floorDiv(low + high, 2); // replaced with mid = low + (high - low) / 2;
            int count = 0;

            for (int n: nums) {
                if (n <= mid) { // !!! ==
                    count++;
                }
            }

            if (count > mid) {
                high = mid; // !!! ==
            } else {
                low = mid + 1;
            }
        }

        return Math.floorDiv(low + high, 2);
    }
}
