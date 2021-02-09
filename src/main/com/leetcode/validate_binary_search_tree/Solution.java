package com.leetcode.validate_binary_search_tree;

/**
 * Validate binary search tree
 *
 * big o: n
 * recursion
 */
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, (long) Integer.MIN_VALUE - 1, (long) Integer.MAX_VALUE + 1);// note that using double as min/max is to handle edge case such as 'integer.min' as value
    }

    private boolean isValidBST(TreeNode node, double min, double max) {
        if (node == null) {
            return true; // should be true
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max); // point here is to check if value of the node doesn't exceed the specified max or lower the specified min
    }
}
