package io.educative.bfs;

import java.util.*;
import java.util.stream.Collectors;

public class BinaryTreeZigZagLevelOrderTraversal {
    public static List<List<Node>> zigZagLevelOrderTraversal(Node root) {
        // WRITE YOUR BRILLIANT CODE HERE
        List<List<Node>> myList = new ArrayList<>();
        Deque<Node> deque = new ArrayDeque<>();
        boolean leftToRight = true;

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
            if (!leftToRight) {
                Collections.reverse(newList);
            }
            myList.add(newList);
            leftToRight = !leftToRight;
        }

        return myList;
    }

    public static void main(String[] args) {
        String[] inputs = {"1 2 4 x 7 x x 5 x 8 x x 3 x 6 x x"};
        for (int i = 0; i<inputs.length; i++) {
            Node root = Node.buildTree(Arrays.stream(inputs[i].split(" ")).iterator());
            List<List<Node>> actual_output = zigZagLevelOrderTraversal(root);
            String actualData = "";

            for (int j = 0; j< actual_output.size() ;j++) {
                List<Node> level = actual_output.get(j);
                actualData  += "["+level.stream().map(node -> Integer.toString(node.val)).collect(Collectors.joining(","))+"]";
            }
            System.out.println("Lowest common ancestor : [" + actualData+"]");
        }
    }
}
