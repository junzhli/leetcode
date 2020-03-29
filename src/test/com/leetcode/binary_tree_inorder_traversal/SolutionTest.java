package com.leetcode.binary_tree_inorder_traversal;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void inorderTraversal() {
        Solution sol = new Solution();
        Solution.TreeNode last = new Solution.TreeNode(3);
        Solution.TreeNode lastSec = new Solution.TreeNode(2);
        lastSec.left = last;
        Solution.TreeNode input1 = new Solution.TreeNode(1);
        input1.right = lastSec;

        List<Integer> res1 = sol.inorderTraversal(input1);
        assertEquals(Arrays.asList(1, 3, 2), res1);

        Solution.TreeNode input2 = new Solution.TreeNode(1);
        input2.left = new Solution.TreeNode(2);

        List<Integer> res2 = sol.inorderTraversal(input2);
        assertEquals(Arrays.asList(2, 1), res2);


    }
}