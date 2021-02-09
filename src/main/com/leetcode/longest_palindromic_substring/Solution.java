package com.leetcode.longest_palindromic_substring;

class Solution {

    // round 2: write code in leetcode console window
    // time complexity: o(n^2), since expending palindromic takes o(n) time, the overall is n^2
    // len = 1, 0-0, 1-1, ..., n-1-n-1 => n times
    // len = 2, 0-2, 2-3, ..., n-1-n => n - 1 times
    // ...
    // len = n, 0-n-1 => 1 times
    // we can get the overall is n^2
    // space complexity: 2d array: n^2
    public String longestPalindrome(String s) {
        // this problem is where dp comes into play: we have to find palindromic substrings by looking substrings with length from 0 to s.length one by one
        // you can take an example of looking at substring with length s.length = 7, and it can use recursion by checking whether substring with length 7-1 from index 1 to 6 is palindromic to know it is needed to check 0 and
        // here is my thought: we have to find a way to get solved sub-problems where the substring is palindromic. firstly, we need a data structure to help us remember this: declare an 2d array which its x, y represent the substring in range from x to y is palindromic
        int length = s.length();
        boolean[][] isPalindromic = new boolean[length][length];

        // to get the last substring with max length, we take a note for its max length and its start index
        int maxLength = 0;
        int startAt = -1;

        // solves all substring with length 1
        for (int i = 0; i < s.length(); i++) {
            isPalindromic[i][i] = true;
            maxLength = 1;
            startAt = i;
        }

        // solves all substring with length 2
        for (int i = 0; i + 1 < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalindromic[i][i + 1] = true;

                if (maxLength < 2) {
                    maxLength = 2;
                    startAt = i;
                }
            }
        }

        // dp comes into play: check substring by asking if its substring with range from i + 1 to j - 1 is palindromic and check char at index i and j is the same
        for (int len = 3; len <= s.length(); len++) {
            for (int i = 0; i + len - 1 < s.length(); i++) {
                int j = i + len - 1;
                if (isPalindromic[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    isPalindromic[i][j] = true;

                    if (maxLength < len) {
                        maxLength = len;
                        startAt = i;
                    }
                }
            }
        }

        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < maxLength; i++) {
            strBuilder.append(s.charAt(startAt + i));
        }
        return strBuilder.toString();
    }

    // round 1
//    public String longestPalindrome(String s) {
//        int length = s.length();
//        int maxLength = 0;
//        int startFrom = 0;
//
//        boolean[][] isPalindrome = new boolean[length][length];
//
//        // initialize for all single char with true
//        for (int i = 0; i < length; i++) {
//            isPalindrome[i][i] = true;
//            maxLength = 1;
//            startFrom = i;
//        }
//
//        // start to check all string with length 2
//        for (int i = 0; i < length - 1; i++) {
//            if (s.charAt(i) == s.charAt(i+1)) {
//                isPalindrome[i][i+1] = true;
//                maxLength = 2;
//                startFrom = i;
//            }
//        }
//
//        // start to check all string with length greater than 2
//        for (int k = 3; k <= length; k++) {
//
//            // note: we start from zero, so all var related to k needs to be fixed by "1" (+/-)
//            for (int i = 0; i < length - k + 1; i++) { // k + 1
//
//                int j = i + k - 1; // k - 1
//
//                // set i to j as true while its previous data is palindrome: ? bb ? (dynamic programming)
//                if (isPalindrome[i + 1][j - 1] && (s.charAt(i) == s.charAt(j))) {
//                    isPalindrome[i][j] = true;
//
//                    if (maxLength < k) {
//                        maxLength = k;
//                        startFrom = i;
//                    }
//                }
//            }
//
//        }
//
//        StringBuilder maxStr = new StringBuilder();
//        if (maxLength != 0) {
//            for (int i = startFrom; i < startFrom + maxLength; i++) {
//                maxStr.append(s.charAt(i));
//            }
//        }
//
//        return maxStr.toString();
//    }
}
