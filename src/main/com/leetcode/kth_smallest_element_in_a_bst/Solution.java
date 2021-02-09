package com.leetcode.kth_smallest_element_in_a_bst;

import java.util.ArrayList;
import java.util.List;

/**
 * Terminology: binary search tree (BST)
 *
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 *
 * assume that 1 <= k <= number of BST's total elements
 */
public class Solution {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    // round 2
    // use dfs traversal - inorder (left, visit root, right)
    private int k;
    private int res;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        kthSmallest(root);
        return res;
    }

    private void kthSmallest(TreeNode root) {
        if (root == null) {
            return;
        }

        if (this.k <= 0) {
            return;
        }

        kthSmallest(root.left);
        if (this.k <= 0) {
            return;
        }
        res = root.val;
        this.k -= 1;
        if (this.k <= 0) {
            return;
        }
        kthSmallest(root.right);
    }


    // round 1
//    List<Integer> arr;
//
//    public int kthSmallest(TreeNode root, int k) {
//        arr = new ArrayList<>();
//        helper(root, k);
//        return arr.get(k - 1); // * (k - 1)
//    }
//
//    private void helper(TreeNode node, int k) {
//        if (arr.size() == k) {
//            return;
//        }
//
//        if (node.left != null) {
//            helper(node.left, k);
//        }
//
//        arr.add(node.val);
//
//        if (node.right != null) {
//            helper(node.right, k);
//        }
//    }
}
