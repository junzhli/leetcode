package self.alg.binary_tree.bfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void binaryTreeBFS() {
        Solution.Node root = new Solution.Node(1);
        root.left= new Solution.Node(2);
        root.right= new Solution.Node(3);
        root.left.left= new Solution.Node(4);
        root.left.right= new Solution.Node(5);

        Solution sol = new Solution();
        System.out.println("Level order traversal of binary tree is ");
        sol.binaryTreeBFS(root);

    }
}