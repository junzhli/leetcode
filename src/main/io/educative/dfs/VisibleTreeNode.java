package io.educative.dfs;

import java.util.Arrays;
import java.util.Iterator;

public class VisibleTreeNode {
    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }

        public static Node buildTree(Iterator<String> iter) {
            String nxt = iter.next();
            if (nxt.equals("x")) return null;
            Node node = new Node(Integer.parseInt(nxt));
            node.left = buildTree(iter);
            node.right = buildTree(iter);
            return node;
        }

    }

    static int dfs(Node root) {
        return helper(root, Integer.MIN_VALUE);
    }

    static private int helper(Node root, int max) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        if (root.val > max) {
            count++;
        }

        if (root.left != null) {
            count += helper(root.left, Integer.max(max, root.val));
        }

        if (root.right != null) {
            count += helper(root.right, Integer.max(max, root.val));
        }

        return count;
    }

    public static void main(String[] args) {
        String[] inputs ={"5 4 3 x x 8 x x 6 x x", "-100 x -500 x -50 x x", "9 8 11 x x 20 x x 6 x x"};
        int[] expected_outputs = {3, 2, 3};
        for(int i = 0; i < inputs.length; i++) {
            Node root = Node.buildTree(Arrays.stream(inputs[i].split(" ")).iterator());
            System.out.println("Visible tree node : "+ dfs(root));
        }
    }
}
