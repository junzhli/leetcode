package com.leetcode.maximum_binary_tree;


// t.c. o (n)  s.c. log(n) --> tree height
public class Solution {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return new TreeNode(nums[start]);
        }

        int maxIndex = findMax(nums, start, end);
        if (maxIndex == -1) {
            return null;
        }

        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = buildTree(nums, start, maxIndex - 1);
        root.right = buildTree(nums, maxIndex + 1, end);

        return root;
    }

    private int findMax(int[] nums, int start, int end) {
        if (start > end) {
            return -1;
        }

        int maxIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}
