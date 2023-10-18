package io.educative.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Given a binary tree, find the depth of the shallowest leaf node.
 */
public class BinaryTreeMinDepth {
    public static int getBinaryTreeMinDepth(Node root) {
        // WRITE YOUR BRILLIANT CODE HERE
        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(root);

        int depth = 1;
        while (!deque.isEmpty()) {
            int n = deque.size();

            for (int i = 0; i < n; i++) {
                Node node = deque.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }

                if (node.left != null) {
                    deque.offer(node.left);
                }

                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            depth += 1;
        }

        return depth;
    }

    public static void main(String[] args) {
        String[] inputs ={"1 2 4 x 7 x x 5 x x 3 x 6 x x","0 x x"};
        for (int i = 0; i<inputs.length; i++) {
            Node root = Node.buildTree(Arrays.stream(inputs[i].split(" ")).iterator());
            System.out.println("Binary tree min depth : " + getBinaryTreeMinDepth(root));
        }
    }
}
