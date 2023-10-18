package io.educative.back_tracking;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * We have a message to decode. Letters are encoded to digits by their position in the alphabet:
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Y -> 25
 * Z -> 26
 *
 * Given a non-empty string of digits, how many ways are there to decode it?
 * Example 1#
 *
 * Input: "18"
 *
 * Output: 2
 *
 * Explanation: "18" can be decoded as "AH" or "R"
 * Example 2#
 *
 * Input: "123"
 *
 * Output: 3
 *
 * Explanation: "123" can be decoded as "ABC", "LC", "AW"
 */
public class DecodeString {
    private static final List<String> LETTERS = IntStream.range(1, 27).mapToObj(Integer::toString).collect(Collectors.toList());

    public static int countDecodeWays(String digits) {
        int[] memo = new int[digits.length()];
        Arrays.fill(memo, -1);
        return helper(digits, 0, memo);
    }

    private static int helper(String digits, int len, int[] memo) { // here memo[i] stores ans for substring(i, length)
        if (len == digits.length()) {
            return 1;
        }

        if (memo[len] != -1) {
            return memo[len];
        }

        int ways = 0;
        for (String L: LETTERS) {
            if (digits.substring(len).startsWith(L)) {
                ways += helper(digits, len + L.length(), memo);
            }
        }
        memo[len] = ways;

        return ways;
    }

    public static void main(String[] args) {
        String[] inputs = {"12", "123", "11223"};
        for (int i = 0; i<inputs.length; i++) {
            System.out.println("Decode ways : " + countDecodeWays(inputs[i]));
        }
    }
}

/**
 * Explanation#
 *
 * This is a combinatorial search problem so we apply the three-step system:
 * 1. Identify states#
 *
 * What state do we need to know whether we have decoded a string?
 *
 *     We can keep track of the number of digits we have already matched in index i. When i == length of digits, we have finished.
 *
 * What state do we need to decide which child nodes of the state-space tree should be visited next?
 *
 * Since there’s no constraint on which letters can be used for decoding, we don’t need any state here.
 * 2. Draw the space-state tree#
 *
 *
 * 3. DFS#
 *
 * Using the backtracking template as a basis, we add the state we identified in step 1:
 *
 *     i for the number of digits we have already matched.
 *
 * DFS returns the number of ways we can decode digits[i:].
 */
