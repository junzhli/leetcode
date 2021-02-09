package com.leetcode.check_completeness_of_a_binary_tree;

import java.util.*;

public class Solution {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

//    public boolean isCompleteTree(TreeNode root) { // tree is h, and nodes is in range from 2^h - 1 to 2^h-1 - 1
//        int height = findHeight(root);
//        if (height == 0) {
//            return true;
//        }
//
//        List<Integer> leafNodes = new ArrayList<>();
//        boolean complete = helper(root, 1, height, 1, leafNodes);
//        if (!complete) {
//            return false;
//        }
//        leafNodes.sort(Integer::compareTo);
//
//        int start = (int) Math.pow(2, height - 1);
//        int end = (int) Math.pow(2, height) - 1;
//        for (int i = start; i <= end; i++) {
//            if (i - start >= leafNodes.size()) {
//                break;
//            }
//
//            if (leafNodes.get(i - start) != i) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    private boolean helper(TreeNode root, int h, int height, int id, List<Integer> nodes) {
//        if (root == null) {
//            if (h < height) {
//                return false;
//            }
//            return true;
//        }
//
//        if (h != height) {
//            if (!helper(root.left, h + 1, height, 2 * id, nodes)) return false;
//            if (!helper(root.right, h + 1, height, 2 * id + 1, nodes)) return false;
//            return true;
//        }
//
//        nodes.add(id);
//        return true;
//    }
//
//    private int findHeight(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
//    }

    // using BFS traversal, if popped item is null, then stack should be empty after this.
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean end = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                end = true; // indicator for a node returned with null in previous few steps
            } else {
                if (end) {
                    return false;
                }
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return true;
    }
}
