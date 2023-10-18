package io.educative.back_tracking;

import java.util.List;

/**
 * Given a string and a list of words, determine if the string can be constructed from concatenating words from the list of words. A word can be used multiple times.
 *
 * Input:
 *
 * s = "educativeio"
 *
 * words = ["educative", "io"]
 *
 * Output: true
 *
 * Input:
 *
 * s = "aab"
 *
 * words = ["a", "c"]
 *
 * Output: false
 */
public class WordBreak {
    public static boolean wordBreak(String s, String[] words) {
        return helper(s, words, new StringBuilder(), new Boolean[s.length()]);
    }

    private static boolean helper(String s, String[] words, StringBuilder intermediate, Boolean[] processedMemoByLength) {
        if (s.equals(intermediate.toString())) {
            return true;
        }

        int oldLength = intermediate.length();
        if (processedMemoByLength[oldLength] != null) {
            return processedMemoByLength[oldLength];
        }

        boolean result = false;
        for (int i = 0; i < words.length; i++) {
            if (intermediate.length() + words[i].length() > s.length()) {
                continue;
            }

            if (s.substring(intermediate.length()).startsWith(words[i])) {
                intermediate.append(words[i]);
                result = result || helper(s, words, intermediate, processedMemoByLength);
            }

            intermediate = new StringBuilder(intermediate.substring(0, oldLength));
        }

        processedMemoByLength[oldLength] = result;
        return processedMemoByLength[oldLength];
    }

    // without memorization
//    private static boolean helper(String s, String[] words, StringBuilder intermediate) {
//        if (s.equals(intermediate.toString())) {
//            return true;
//        }
//
//        for (int i = 0; i < words.length; i++) {
//            if (intermediate.length() + words[i].length() > s.length()) {
//                continue;
//            }
//            int oldLength = intermediate.length();
//            if (s.substring(intermediate.length()).startsWith(words[i])) {
//                intermediate.append(words[i]);
//                if (helper(s, words, intermediate)) {
//                    return true;
//                }
//            }
//
//            intermediate = new StringBuilder(intermediate.substring(0, oldLength));
//        }
//
//        return false;
//    }

    public static void main(String[] args) {
        String[] inputs = {"algomonster", "aab", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"};
        String[] inputs2 = {"algo monster", "a c", "a aa aaa aaaa aaaaa aaaaaa aaaaaaa aaaaaaaa aaaaaaaaa aaaaaaaaaa"};

        for (int i = 0; i<inputs.length; i++) {
            System.out.println("Word break : " + wordBreak(inputs[i], inputs2[i].split(" ")));
        }
    }
}
