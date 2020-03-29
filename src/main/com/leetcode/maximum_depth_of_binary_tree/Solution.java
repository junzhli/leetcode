package com.leetcode.maximum_depth_of_binary_tree;

public class Solution {
    public class TreeNode {
        int val;
        Solution.TreeNode left;
        Solution.TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
