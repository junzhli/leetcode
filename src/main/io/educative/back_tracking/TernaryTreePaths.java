package io.educative.back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TernaryTreePaths {
    static class Node {
        int val;
        Node[] children;

        public Node(int val, Node[] children) {
            this.val = val;
            this.children = children;
        }

        public static Node buildTree(Iterator<String> nodes) {
            String nxt = nodes.next();
            if (nxt.equals("x")) return null;
            Node node = new Node(Integer.parseInt(nxt), new Node[3]);
            for (int i = 0; i < 3; i++) {
                node.children[i] = buildTree(nodes);
            }
            return node;
        }
    }

    static List<List<Node>> backtrack(Node root) {
        List<List<Node>> result = new ArrayList<>();
        helper(root, result, new ArrayList<>());
        return result;
    }

    private static void helper(Node root, List<List<Node>> result, List<Node> path) {
        List<Node> pathCopy = new ArrayList<>(path);
        pathCopy.add(root);

        if (root.children.length == 3 && root.children[0] == null && root.children[1] == null && root.children[2] == null) {
            result.add(new ArrayList<>(pathCopy));
            return;
        }

        for (Node child: root.children) {
            if (child != null) {
                helper(child, result, pathCopy);
            }
        }
    }

    public static void main(String[] args) {
        String[] inputs = {"1 2 5 x x x x x 3 x x x 4 x x x", "1 2 3 x x x 4 x x x 7 x x x 5 x x x 6 x x x"};
        for (int i = 0; i<inputs.length; i++) {
            Node root = Node.buildTree(Arrays.stream(inputs[i].split(" ")).iterator());
            List<List<Node>> result = backtrack(root);
            for (List<Node> r: result) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < r.size(); j++) {
                    Node node = r.get(j);
                    stringBuilder.append(node.val);
                    if (j != r.size() - 1) {
                        stringBuilder.append(" -> ");
                    }
                }
                System.out.println("Answer: " + stringBuilder.toString());
            }
            System.out.println("======");
//            System.out.println("Ternary tree paths : " + Arrays.toString(result.toArray(new String[result.size()])));
        }
    }
}
