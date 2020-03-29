package com.leetcode.construct_binary_tree_from_preorder_and_inorder_traversal;

import java.util.HashMap;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = buildIndex(inorder);
        return buildTree(preorder, map, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, HashMap<Integer, Integer> map, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        int inIndex = map.get(rootVal);
        int numsLeft = inIndex - inStart;

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preorder, map, preStart + 1, preEnd, inStart, inIndex - 1);
        root.right = buildTree(preorder, map, preStart + numsLeft + 1, preEnd, inIndex + 1, inEnd);
        return root;
    }

    private HashMap<Integer, Integer> buildIndex(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        return map;
    }
}
