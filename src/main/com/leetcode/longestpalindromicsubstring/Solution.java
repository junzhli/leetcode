package com.leetcode.longestpalindromicsubstring;

class Solution {

    public String longestPalindrome(String s) {
        int length = s.length();
        int maxLength = 0;
        int startFrom = 0;

        boolean[][] isPalindrome = new boolean[length][length];

        // initialize for all single char with true
        for (int i = 0; i < length; i++) {
            isPalindrome[i][i] = true;
            maxLength = 1;
            startFrom = i;
        }

        // start to check all string with length 2
        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                isPalindrome[i][i+1] = true;
                maxLength = 2;
                startFrom = i;
            }
        }

        // start to check all string with length greater than 2
        for (int k = 3; k <= length; k++) {

            // note: we start from zero, so all var related to k needs to be fixed by "1" (+/-)
            for (int i = 0; i < length - k + 1; i++) { // k + 1

                int j = i + k - 1; // k - 1

                // set i to j as true while its previous data is palindrome: ? bb ? (dynamic programming)
                if (isPalindrome[i + 1][j - 1] && (s.charAt(i) == s.charAt(j))) {
                    isPalindrome[i][j] = true;

                    if (maxLength < k) {
                        maxLength = k;
                        startFrom = i;
                    }
                }
            }

        }

        StringBuilder maxStr = new StringBuilder();
        if (maxLength != 0) {
            for (int i = startFrom; i < startFrom + maxLength; i++) {
                maxStr.append(s.charAt(i));
            }
        }

        return maxStr.toString();
    }
}
