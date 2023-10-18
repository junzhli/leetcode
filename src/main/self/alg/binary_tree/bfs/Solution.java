package self.alg.binary_tree.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static class Node
    {
        int data;
        Node left, right;
        public Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    /**
     * Binary tree traversal through BFS using iteration with the help of queue
     *
     * t.c. o(n)
     *
     */
    public void binaryTreeBFS(Node n) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(n);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.data);

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }


    /**
     * Binary tree traversal through BFS using recursion
     *
     */

//    public void binaryTreeBFS(Node n) {
//        int h = height(n);
//        for (int i = 0; i < h; i++) {
//            printLevelNode(n, i);
//        }
//    }
//
//    private void printLevelNode(Node n, int level) {
//        if (n == null) {
//            return;
//        }
//
//        if (level == 0) {
//            System.out.println(n.data);
//        }
//
//        printLevelNode(n.left, level - 1);
//        printLevelNode(n.right, level - 1);
//    }
//
//    private int height(Node root) {
//        if (root == null) {
//            return 0;
//        }
//
//        return 1 + Math.max(height(root.left), height(root.right));
//    }
}
