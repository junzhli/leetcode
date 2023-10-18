package com.leetcode.house_robber_iii;

import java.util.HashMap;

// https://leetcode.com/problems/house-robber-iii/description/
// https://leetcode.com/problems/house-robber-iii/solutions/1611881/java-3-approaches-recursion-dp-greedy-detailed-explanation/
// t.c. o(n)
// s.c. o(n)
// notice: without the help of hashmap, as of result, it lead to tle error and t.c. becomes o(2^n)
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
    HashMap<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (map.containsKey(root)) {
            return map.get(root);
        }

        // return Math.max(helper(root, true), helper(root, false));
        // to deal with tle problem
        int result =  Math.max(helper(root, true), helper(root, false));
        map.put(root, result);
        return result;
    }

    private int helper(TreeNode curr, boolean inclusive) {
        if (curr == null) {
            return 0;
        }

        if (inclusive) {
            return curr.val + helper(curr.left, false) + helper(curr.right, false);
        } else {
            // return Math.max(helper(curr.left, true) + helper(curr.right,true),
            //     helper(curr.left, false) + helper(curr.right,false));
            // !! consider if we take left.val but not for right.val and vice versa
            return rob(curr.left) + rob(curr.right);
        }
    }
}
