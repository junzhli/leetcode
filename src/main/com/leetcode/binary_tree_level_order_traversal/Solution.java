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
        int h = height(root);

        for (int i = 0; i < h; i++) {
            res.add(getLevelElements(root, i));
        }
        return res;
    }

    private List<Integer> getLevelElements(TreeNode n, int level) {
        List<Integer> res= new ArrayList<>();
        _getLevelElements(n, level, res);
        return res;
    }

    private void _getLevelElements(TreeNode n, int level, List<Integer> res) {
        if (n == null) {
            return;
        }
        if (level == 0) {
            res.add(n.val);
        }
        _getLevelElements(n.left, level - 1, res);
        _getLevelElements(n.right, level - 1, res);
    }

    private int height(TreeNode n) {
        if (n == null) {
            return 0;
        }

        return Math.max(height(n.left), height(n.right)) + 1;
    }
}
