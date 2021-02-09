package com.leetcode.serialize_and_deserialize_binary_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }


    // !!! use preorder to serialize the binary tree
    // split nodes by ','
    // use 'X' to represent null-node
    public class Codec {
        private static final String SPLITTER = ",";
        private static final String NULL_NODE = "X";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder strBuilder = new StringBuilder();
            buildString(root, strBuilder);
            return strBuilder.toString();
        }

        private void buildString(TreeNode root, StringBuilder strBuilder) {
            if (root == null) {
                strBuilder.append(NULL_NODE).append(SPLITTER);
                return;
            }

            strBuilder.append(root.val).append(SPLITTER);
            buildString(root.left, strBuilder);
            buildString(root.right, strBuilder);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(SPLITTER)));
            return buildTree(queue);
        }

        private TreeNode buildTree(Queue<String> queue) {
            String popped = queue.poll();
            if (popped.equals(NULL_NODE)) {
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(popped));
            root.left = buildTree(queue);
            root.right = buildTree(queue);
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}
