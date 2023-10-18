package io.educative.bfs;

/**
 * Word Ladder is “a puzzle that begins with two words, and to solve the puzzle one must find a chain of other words to link the two, in which two adjacent words (that is, words in successive steps) differ by one letter.”
 *
 * For example: COLD → CORD → CARD → WARD → WARM
 *
 * Given a start word, an end word, and a list of dictionary words, determine the minimum number of steps to go from the start word to the end word using only words from the dictionary.
 *
 * Example#
 *
 * Input:
 *
 * start = "COLD"
 * end = "WARM"
 * word_list = ["COLD", "GOLD", "CORD", "SOLD", "CARD", "WARD", "WARM", "TARD"]
 *
 * Output:
 *
 * 4
 */
public class WordLadder {
    /**
     * import java.util.*;
     * class Solution {
     *     public static final char[] ALPHABETS = new char[26];
     *     static {
     *         // ascii representation of english alphabets a - z are numbers 97 - 122
     *         for (int i = 0; i < 26; i++) {
     *             ALPHABETS[i] = (char) (i + 'a');
     *         }
     *     }
     *
     *     public static int wordLadder(String begin, String end, String[] wordList) {
     *         // WRITE YOUR BRILLIANT CODE HERE
     *         Deque<Node> deque = new ArrayDeque<>();
     *         deque.offer(begin);
     *
     *         while (!deque.isEmpty()) {
     *             // ... enque if finds adj words in wordList, using 'isAdjWord'
     *             // ... similar to last problem
     *         }
     *         return -1;
     *     }
     *
     *     private static boolean isAdjWord(String word, String candidate) {
     *         if (word.length() != candidate.length()) {
     *             return false;
     *         }
     *
     *         int count = 0;
     *         for (int i = 0; i < word.length(); i++) {
     *             if (word.charAt(i) != candidate.charAt(i)) {
     *                 count += 1;
     *                 if (count > 1) {
     *                     return false;
     *                 }
     *             }
     *         }
     *
     *         return count == 1;
     *     }
     * }
     */
}

/**
 * official
 *
 * import java.util.*;
 * class Solution {
 *     public static final char[] ALPHABETS = new char[26];
 *     static {
 *         // ascii representation of english alphabets a - z are numbers 97 - 122
 *         for (int i = 0; i < 26; i++) {
 *             ALPHABETS[i] = (char) (i + 'a');
 *         }
 *     }
 *
 *     public static int wordLadder(String begin, String end, String[] wordList) {
 *         // make a set because existence query is O(1) vs O(N) for list
 *         Set<String> words = new HashSet<>(Arrays.asList(wordList));
 *         ArrayDeque<String> queue = new ArrayDeque<>();
 *         queue.add(begin);
 *         int distance = 0;
 *         while (queue.size() > 0) {
 *             int n = queue.size();
 *             distance++;
 *             for (int i = 0; i < n; i++) {
 *                 String word = queue.pop();
 *                 for (int j = 0; j < word.length(); j++) {
 *                     for (char c : ALPHABETS) {
 *                         StringBuilder wordBuilder = new StringBuilder(word.length());
 *                         wordBuilder.append(word.substring(0, j));
 *                         wordBuilder.append(c);
 *                         wordBuilder.append(word.substring(j + 1));
 *                         String nextWord = wordBuilder.toString();
 *                         if (!words.contains(nextWord)) continue;
 *                         if (nextWord.equals(end)) return distance;
 *                         queue.add(nextWord);
 *                         // removing from the set is equivalent as marking the word visited
 *                         words.remove(nextWord);
 *                     }
 *                 }
 *             }
 *         }
 *         return 0;
 *     }
 *
 *     // Driver code
 *     public static void main(String[] args) {
 *         String[] inputs = {"cold", "fool"};
 *         String[] inputs1 = {"warm", "sage"};
 *         String[] inputs2 = {"cold  gold  cord  card  ward  warm  tard  sold","fool pool poll pole pale sale sage"};
 *
 *          for(int i = 0; i < inputs.length; i++) {
 *              System.out.println("Word ladder : " + Solution.wordLadder(inputs[i], inputs1[i], inputs2[i].split(" ")));
 *          }
 *     }
 * }
 *
 * Time complexity#
 *
 * At each step/iteration, each letter of the current word can be replaced by one of the other letters in the alphabet. We have to make a copy that is linear time with respect to the length of the string, so the time complexity of each iteration is O(M2)O(M2), where MM is the length of the input source. Then we multiply it by the number of iterations. In the worst case, the number of iterations is the same as the number of words O(N)O(N), so the overall time complexity is O(M2N)O(M2N).
 */
