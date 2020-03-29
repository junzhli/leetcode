package com.leetcode.implement_trie;

public class Solution {
    public static class Trie {
        private class TreeNode {
            boolean isWord;
            TreeNode[] children;

            TreeNode() {
                children = new TreeNode[26]; // a, b, c,... z => [char] - 'a' = 0...25
            }
        }

        TreeNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TreeNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TreeNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                int id = word.charAt(i) - 'a';
                if (curr.children[id] == null) {
                    curr.children[id] = new TreeNode();
                }
                curr = curr.children[id];
            }
            curr.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            return search(word, false);
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return search(prefix, true);
        }

        private boolean search(String keyword, boolean startWith) {
            TreeNode curr = root;

            for (int i = 0; i < keyword.length(); i++) {
                int id = keyword.charAt(i) - 'a';
                if (curr.children[id] == null) {
                    return false;
                }

                curr = curr.children[id];
            }

            return (startWith) || curr.isWord;
        }
    }
}
