package com.leetcode.valid_palindrome;

// https://leetcode.com/problems/valid-palindrome/description/?envType=featured-list&envId=top-interview-questions
public class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            char lc = s.charAt(left);
            char rc = s.charAt(right);
            if (!((lc >= 'a' && lc <= 'z') || (lc >= '0' && lc <= '9'))) {
                left++;
                continue;
            }
            if (!((rc >= 'a' && rc <= 'z') || (rc >= '0' && rc <= '9'))) {
                right--;
                continue;
            }

            if (lc != rc) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
