package com.leetcode.binary_tree_level_order_traversal;

import utils.Array;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        int height = getHeight(root);
        for (int i = 0; i < height; i++) {
            List<Integer> sub = new ArrayList<>();
            getElementByHeight(i, sub, root);
            res.add(sub);
        }

        return res;
    }

    private void getElementByHeight(int level, List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }

        if (level == 0) {
            res.add(root.val);
            return;
        }

        getElementByHeight(level - 1, res, root.left);
        getElementByHeight(level - 1, res, root.right);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        int h = height(root);
//
//        for (int i = 0; i < h; i++) {
//            res.add(getLevelElements(root, i));
//        }
//        return res;
//    }
//
//    private List<Integer> getLevelElements(TreeNode n, int level) {
//        List<Integer> res= new ArrayList<>();
//        _getLevelElements(n, level, res);
//        return res;
//    }
//
//    private void _getLevelElements(TreeNode n, int level, List<Integer> res) {
//        if (n == null) {
//            return;
//        }
//        if (level == 0) {
//            res.add(n.val);
//        }
//        _getLevelElements(n.left, level - 1, res);
//        _getLevelElements(n.right, level - 1, res);
//    }
//
//    private int height(TreeNode n) {
//        if (n == null) {
//            return 0;
//        }
//
//        return Math.max(height(n.left), height(n.right)) + 1;
//    }
}
