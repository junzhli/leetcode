package self.alg.binary_tree.dfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void binaryTreeInOrder() {
        Solution sol = new Solution();
        Solution.Node root = new Solution.Node(1);
        root.left = new Solution.Node(2);
        root.right = new Solution.Node(3);
        root.left.left = new Solution.Node(4);
        root.left.right = new Solution.Node(5);
        sol.binaryTreeInOrder(root);
    }

    @Test
    void binaryTreePreOrder() {
        Solution sol = new Solution();
        Solution.Node root = new Solution.Node(1);
        root.left = new Solution.Node(2);
        root.right = new Solution.Node(3);
        root.left.left = new Solution.Node(4);
        root.left.right = new Solution.Node(5);
        sol.binaryTreePreOrder(root);
    }

    @Test
    void binaryTreePostOrder() {
        Solution sol = new Solution();
        Solution.Node root = new Solution.Node(1);
        root.left = new Solution.Node(2);
        root.right = new Solution.Node(3);
        root.left.left = new Solution.Node(4);
        root.left.right = new Solution.Node(5);
        sol.binaryTreePostOrder(root);
    }
}