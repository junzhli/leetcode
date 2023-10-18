package io.educative.bfs;

import java.util.*;
import java.util.stream.Collectors;



// t.c. o(n)

/**
 * Given a binary tree, return its level order traversal. The input is the root node of the tree. The output should be a list of lists containing tree nodes at each level.
 */
public class BinaryTreeLevelOrderTraversal {
    public static List<List<Node>> levelOrderTraversal(Node root) {
        // WRITE YOUR BRILLIANT CODE HERE
        List<List<Node>> myList = new ArrayList<>();
        Deque<Node> deque = new ArrayDeque<>();

        deque.offer(root);
        while (deque.size() != 0) {
            int n = deque.size();
            List<Node> newList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                Node node = deque.poll();
                newList.add(node);

                if (node.left != null) {
                    deque.offer(node.left);
                }

                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            myList.add(newList);
        }

        return myList;
    }

    public static void main(String[] args) {
        String[] inputs = {"1 2 4 x 7 x x 5 x x 3 x 6 x x","0 x x"};
        for (int i = 0; i<inputs.length; i++) {
            Node root = Node.buildTree(Arrays.stream(inputs[i].split(" ")).iterator());
            List<List<Node>> actual_output = levelOrderTraversal(root);
            String[] result = new String[inputs.length];
            String actualData = "";
            for (int j = 0; j< actual_output.size() ;j++) {
                List<Node> level = actual_output.get(j);
                actualData  += "["+level.stream().map(node -> Integer.toString(node.val)).collect(Collectors.joining(","))+"]";
            }
            System.out.println("Binary tree level order traversal : [" +actualData+"]");
        }
    }
}
