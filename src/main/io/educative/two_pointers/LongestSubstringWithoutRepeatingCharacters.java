package io.educative.two_pointers;

import java.util.HashSet;
import java.util.Set;

// t.c. o(n)
// skipped due to same problem in leetcode, using sliding window strategies
public class LongestSubstringWithoutRepeatingCharacters {
    public static int longestSubstringWithoutRepeatingCharacters(String s) {
        int n = s.length();
        int longest = 0;
        int l = 0, r = 0;
        // use hashset to keep state that character existence
        Set<Character> window = new HashSet<>();
        // follow-up
        // if we find the existing char in iteration, we start another substring from the last position of existing char + 1
        while (r < n) {
            if (!window.contains(s.charAt(r))) {
                window.add(s.charAt(r));
                r++;
            } else {
                window.remove(s.charAt(l));
                l++;
            }
            longest = Math.max(longest, r - l);
        }
        return longest;
    }

    //Driver code
    public static void main(String[] arg){
        String[] inputs = {"abcdbea","aba","abccabcabcc","aaaabaaa"};
        for(int i = 0; i < inputs.length; i++) {
            System.out.println("Longest substring without repeating characters : "+longestSubstringWithoutRepeatingCharacters(inputs[i]));
        }
    }
}
