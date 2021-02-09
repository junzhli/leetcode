package com.leetcode.construct_binary_tree_from_inorder_and_postorder_traversal;

import java.util.HashMap;

public class Solution {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  // round 1
    // related problem: construct_binary_tree_from_preorder_and_inorder_traversal
  // t.c. o(n)
    // s.c. o(n)
    // use hashtable: assumes no duplicates in the tree
    // follow-up:
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> hashTable = buildIndex(inorder);
        return buildTree(inorder, postorder, 0, inorder.length - 1, postorder.length - 1, 0, hashTable);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd, HashMap<Integer, Integer> hashTable) {
        if (postStart < postEnd || inStart > inEnd) {
            return null;
        }

        int rootVal = postorder[postStart];
        int inPosition = hashTable.get(rootVal);
        int rightNodes = inEnd - inPosition;

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(inorder, postorder, inStart, inPosition - 1, postStart - rightNodes - 1, postEnd, hashTable);
        root.right = buildTree(inorder, postorder, inPosition + 1, inEnd, postStart - 1, postStart - rightNodes, hashTable);
        // root.right = buildTree(inorder, postorder, inStart + 1, inEnd, postStart - 1, postStart - rightNodes, hashTable);
        return root;
    }

    private HashMap<Integer, Integer> buildIndex(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i], i);
        }
        return hashMap;
    }
}
