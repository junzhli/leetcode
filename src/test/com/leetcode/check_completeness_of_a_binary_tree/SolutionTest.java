package com.leetcode.check_completeness_of_a_binary_tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

//    @Test
//    void isCompleteTree() {
//        Solution sol = new Solution();
//        Solution.TreeNode six = new Solution.TreeNode(6);
//        Solution.TreeNode five = new Solution.TreeNode(5);
//        Solution.TreeNode four = new Solution.TreeNode(4);
//        Solution.TreeNode three = new Solution.TreeNode(3);
//        Solution.TreeNode two = new Solution.TreeNode(2);
//        Solution.TreeNode one = new Solution.TreeNode(1);
//        two.left = four;
//        two.right = five;
//        three.left = six;
//        one.left = two;
//        one.right = three;
//
//        boolean res = sol.isCompleteTree(one);
//        assertEquals(true, res);
//    }

    @Test
    void isCompleteTree() {
        Solution sol = new Solution();
        Solution.TreeNode fiften = new Solution.TreeNode(6);
        Solution.TreeNode thrten = new Solution.TreeNode(6);
        Solution.TreeNode twv = new Solution.TreeNode(6);
        Solution.TreeNode elev = new Solution.TreeNode(6);
        Solution.TreeNode ten = new Solution.TreeNode(6);
        Solution.TreeNode nine = new Solution.TreeNode(6);
        Solution.TreeNode eight = new Solution.TreeNode(8);
        Solution.TreeNode seven = new Solution.TreeNode(7);
        Solution.TreeNode six = new Solution.TreeNode(6);
        Solution.TreeNode five = new Solution.TreeNode(5);
        Solution.TreeNode four = new Solution.TreeNode(4);
        Solution.TreeNode three = new Solution.TreeNode(3);
        Solution.TreeNode two = new Solution.TreeNode(2);
        Solution.TreeNode one = new Solution.TreeNode(1);
        four.left = eight;
        four.right = nine;
        five.left = ten;
        five.right = elev;
        six.left = twv;
        six.right = thrten;
        seven.right = fiften;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
        one.left = two;
        one.right = three;

        boolean res = sol.isCompleteTree(one);
        assertEquals(false, res);
    }
}