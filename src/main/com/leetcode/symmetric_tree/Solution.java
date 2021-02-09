package com.leetcode.symmetric_tree;

/**
 * https://leetcode.com/problems/symmetric-tree/submissions/
 * t.c big o n
 * s.c big o n
 */
public class Solution {
    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }

    // round 2
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        return (root1.val == root2.val) && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left); // think properties on symmetric tree: every leftTree.right == rightTree.left && leftTree.left == rightTree.right
    }

    // round 1
//    public boolean isSymmetric(TreeNode root) {
//        return isMirror(root, root);
//    }
//
//    private boolean isMirror(TreeNode root1, TreeNode root2) {
//        if (root1 == null && root2 == null) return true;
//        if (root1 == null || root2 == null) return false;
//        return (root1.val == root2.val) && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
//    }
}
