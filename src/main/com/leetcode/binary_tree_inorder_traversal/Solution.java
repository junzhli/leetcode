package com.leetcode.binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    /**
     * https://leetcode.com/problems/binary-tree-inorder-traversal
     *
     * visit from the top node, traverse from its left node util the next node's left is null. Then, print the next node, keeping toward to its right node if not null.
     * keep visiting until the completion of inorder traversal tree
     *
     * t: n
     * s: n
     *
     * hint: take advantage of stack tracking all routes (follows FILO)
     */

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }

        return res;
    }

}
