package com.leetcode.word_search_ii;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    class Word {
        boolean isWord;
        Word[] next;

        Word() {
            isWord = false;
            next = new Word[26];
        }
    }

    private void indexWord(String word, Word[] root) {
        Word[] curr = root;
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (curr[c - 'a'] == null) {
                curr[c - 'a'] = new Word();
            }

            if (i == charArray.length - 1) {
                curr[c - 'a'].isWord = true;
            } else {
                curr = curr[c- 'a'].next;
            }
        }

    }

    // private boolean search(String prefix, Word[] root, boolean isWord) {
    //     Word[] curr = root;
    //     char[] charArray = prefix.toCharArray();
    //     for (int i = 0; i < charArray.length; i++) {
    //         char c = charArray[i];
    //         if (curr[c - 'a'] == null) {
    //             return false;
    //         }

    //         if (i == charArray.length - 1) {
    //             if (isWord && !curr[c - 'a'].isWord) {
    //                 return false;
    //             }
    //         } else {
    //             curr = curr[c - 'a'].next;
    //         }
    //     }


    //     return true;
    // }

    public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> set = new HashSet<>();
        Word[] root = new Word[26];
        for (String word: words) {
            set.add(word);
            indexWord(word, root);
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtrack(new StringBuilder(), i, j, board, result, root, set);
            }
        }



        return result;
    }

    private void backtrack(StringBuilder str, int x, int y, char[][] board, List<String> result, Word[] root, HashSet<String> set) {
        if (x < 0 || x >= board.length || y < 0 || y >=board[0].length) {
            return;
        }

        char c = board[x][y];

        if (c == '#') {
            return;
        }

        str.append(c);

        if (str.length() > 10) {
            str.deleteCharAt(str.length() - 1);
            return;
        }


        int cIndex = c - 'a';

        if (root[cIndex] == null) {
            str.deleteCharAt(str.length() - 1);
            return;
        }

        // if (!search(str.toString(), root, false)) {
        //     str.deleteCharAt(str.length() - 1);
        //     return;
        // }

        // if (root[cIndex].isWord) {
        //     result.add(str.toString());
        //     // str.deleteCharAt(str.length() - 1);
        //     root[cIndex].isWord = false;
        // }



        if (set.contains(str.toString())) {
            result.add(str.toString());
            set.remove(str.toString());
            // str.deleteCharAt(str.length() - 1); //!!!!!!
            // return;
        }

        board[x][y] = '#';

        backtrack(str, x - 1, y, board, result, root[cIndex].next, set);
        backtrack(str, x + 1, y, board, result, root[cIndex].next, set);
        backtrack(str, x, y - 1, board, result, root[cIndex].next, set);
        backtrack(str, x, y + 1, board, result, root[cIndex].next, set);

        board[x][y] = c;

        str.deleteCharAt(str.length() - 1); // !!!!!!
    }
}
