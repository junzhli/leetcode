package com.leetcode.binary_tree_zigzag_level_order_traversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        int h = height(root);

        for (int i = 0; i < h; i++) {
            res.add(getLevelElements(root, i, (i % 2 == 0)));
        }
        return res;
    }

    private List<Integer> getLevelElements(TreeNode n, int level, boolean arrowRight) {
        List<Integer> res= new ArrayList<>();
        _getLevelElements(n, level, res, arrowRight);
        return res;
    }

    private void _getLevelElements(TreeNode n, int level, List<Integer> res, boolean arrowRight) {
        if (n == null) {
            return;
        }
        if (level == 0) {
            res.add(n.val);
        }

        if (arrowRight) {
            _getLevelElements(n.left, level - 1, res, arrowRight);
            _getLevelElements(n.right, level - 1, res, arrowRight);
        } else {
            _getLevelElements(n.right, level - 1, res, arrowRight);
            _getLevelElements(n.left, level - 1, res, arrowRight);
        }
    }

    private int height(TreeNode n) {
        if (n == null) {
            return 0;
        }

        return Math.max(height(n.left), height(n.right)) + 1;
    }
}
