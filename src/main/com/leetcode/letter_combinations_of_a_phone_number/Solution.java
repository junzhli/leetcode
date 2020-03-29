package com.leetcode.letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] CHARS = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        ArrayList<String> res = new ArrayList<>();

        /**
         * Case by case
         * length === 0 => return empty array
         * length  >  0 => return flatten(...)
         */
        if (digits.length() == 0) {
            return res;
        }

        if (digits.length() == 1) {
            return flatten(new String[]{CHARS[Integer.valueOf(digits)]});
        }

        String[] chars = new String[digits.length()];
        for (int digitIndex = 0; digitIndex < digits.length(); digitIndex++) {
            int digit = Character.getNumericValue(digits.charAt(digitIndex));
            chars[digitIndex] = CHARS[digit];
        }
        return flatten(chars);
    }

    /**
     *
     * Mapping all digits to chars as string in order,
     * iterate over the array of strings, grab every string as array of chars, and put those chars in an array
     * loop over the array again when the next string comes from the array of strings
     * concat every char in this array with the char of the next string. the new array of chars replace the last one
     * repeat the operation until finishing the iteration over the array of strings
     */
    private List<String> flatten(String[] strsArr) {
        List<String> res = new ArrayList<>();
        for (int x = 0; x < strsArr.length; x++) {
            char[] chars = strsArr[x].toCharArray();

            if (res.size() == 0) {
                for (int y = 0; y < chars.length; y++) {
                    res.add(String.valueOf(chars[y]));
                }
            } else {
                List<String> newRes = new ArrayList<>();
                for (int z = 0; z < res.size(); z++) {
                    for (int charIndex = 0; charIndex < chars.length; charIndex++) {
                        newRes.add(res.get(z) + chars[charIndex]);
                    }
                }

                res = newRes;
            }
        }
        return res;
    }
}
