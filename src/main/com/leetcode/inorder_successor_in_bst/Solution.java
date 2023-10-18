package com.leetcode.inorder_successor_in_bst;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Solution {
    class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  // other sols
    // https://www.lintcode.com/problem/448/solution/16745
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

      TreeNode cand = null;



      while (root != null) {

          if (p.val >= root.val) {

              root = root.right;

          } else {

              cand = root;

              root = root.left;

          }

      }



      return cand;

  }

    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
//    private TreeNode res = null;
//    private boolean print = false;
//
//    private boolean goExit = false;
//
//    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//        res = null;
//        print = false;
//        goExit = false;
//        // write your code here
//        helper(root, p);
//        return res;
//    }
//
//    private void helper(TreeNode root, TreeNode p) {
//        if (goExit) {
//            return;
//        }
//
//        if (root == null) {
//            return;
//        }
//
//
//
//        helper(root.left, p);
//
//        if (print == true) {
//            res = root;
//            print = false;
//            goExit = true;
//        }
//
//        if (root == p) {
//            print = true;
//        }
//
//        helper(root.right, p);
//    }
}
