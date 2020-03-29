package com.leetcode.convert_sorted_array_to_binary_search_tree;

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
// point: sorted converted it to bst is started with the middle value of the arr
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = start + (end - start) / 2; // !!!attention: be aware of the corner case got overflow: (start + end) / 2 is accepted too
        TreeNode root = new TreeNode(nums[middle]);
        root.left = buildBST(nums, start, middle - 1);
        root.right = buildBST(nums, middle + 1, end);
        return root;
    }
}
