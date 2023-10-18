package com.leetcode.binary_tree_maximum_path_sum;

// https://leetcode.com/problems/binary-tree-maximum-path-sum/description/?envType=featured-list&envId=top-interview-questions
// using dfs
// since there's no vertex connected by more than on edge, so there's no need to keep track of visited node in a hashset or boolean array
// recursion should be more intuitive than using stack
// it's not possible to select both child in a path
// t.c. o(n)
// s.c. o(1)
// https://leetcode.com/problems/binary-tree-maximum-path-sum/solutions/603423/python-recursion-stack-thinking-process-diagram/?envType=featured-list&envId=top-interview-questions
public class Solution {
    public class TreeNode {
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
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode curr) {
        if (curr == null) {
            return 0;
        }

        int leftMax = Math.max(helper(curr.left), 0);
        int rightMax = Math.max(helper(curr.right), 0);

        int currMax = Math.max(curr.val, curr.val + leftMax + rightMax);

        max = Math.max(currMax, max);

        return curr.val + Math.max(leftMax, rightMax); // notice any node in the sequence can be visited at most once, also we can only choose either child of that parent when return
    }
}
