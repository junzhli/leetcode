package com.leetcode.lowest_common_ancestor_of_a_binary_tree;

public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    // round 2
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode isLeft = helper(root.left, p, q);
        TreeNode isRight = helper(root.right, p, q);

        if (isLeft == null && isRight == null) {
            return null;
        }

        if (isLeft != null && isRight != null) {
            return root;
        }

        if (isLeft != null) {
            return isLeft;
        }

        if (isRight != null) {
            return isRight;
        }

        return null;
    }

    // round 1
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == p || root == q || root == null) {
//            return root;
//        }
//
//        TreeNode fromL = lowestCommonAncestor(root.left, p, q);
//        TreeNode fromR = lowestCommonAncestor(root.right, p, q);
//        if (fromL != null && fromR != null) {
//            return root;
//        }
//        return (fromL != null) ? fromL : fromR;
//    }
}
