package io.educative.bfs;

import java.util.*;
import java.util.stream.Collectors;
/**
 * graph: {
 *   0: [1, 2],
 *   1: [0, 2, 3],
 *   2: [0, 1],
 *   3: [1]
 * }
 * A: 0
 * B: 3
 *
 * Given an (unweighted) graph, return the length of the shortest path between two nodes A and B in terms of the number of edges.
 */

/**
 * import java.util.*;
 * import java.util.stream.Collectors;
 *
 * class Solution {
 *     public static int getLengthOfShortestPath(Map<Node, List<Node>> graph, Node A, Node B) {
 *         // WRITE YOUR BRILLIANT CODE HERE
 *         HashSet<Node> visited = new HashSet<>();
 *         Deque<Node> deque = new ArrayDeque<>();
 *         deque.offer(A);
 *         int shortestLength = 0;
 *         while(!deque.isEmpty()) {
 *             shortestLength += 1;
 *             int sameLengthNodes = deque.size();
 *             for (int i = 0; i < sameLengthNodes; i++) {
 *                 Node node = deque.poll();
 *                 visited.add(node);
 *                 List<Node> adjacentNodes = graph.get(node);
 *                 for (Node adjNode: adjacentNodes) {
 *                     if (visited.contains(adjNode)) {
 *                         continue;
 *                     }
 *                     if (adjNode == B) {
 *                         return shortestLength;
 *                     }
 *                     deque.offer(adjNode);
 *                 }
 *
 *             }
 *         }
 *
 *         return -1;
 *     }
 * }
 */

public class ShortestPath {
    public static int getLengthOfShortestPath(Map<Node, List<Node>> graph, Node A, Node B) {
        return bfs(graph, A, B);
    }

    private static List<Node> getNeighbors(Map<Node, List<Node>> graph, Node node) {
        return graph.get(node);
    }

    private static int bfs(Map<Node, List<Node>> graph, Node root, Node target) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        Set<Node> visited = new HashSet<>();
        int level = 0;
        while (queue.size() > 0) {
            int n = queue.size();  // get # of nodes in the current level
            for (int i = 0; i < n; i++) {
                Node node = queue.pop();
                if (node.equals(target)) return level;
                for (Node neighbour : getNeighbors(graph, node)) {
                    if (visited.contains(neighbour)) continue;
                    queue.add(neighbour);
                    visited.add(neighbour);
                }
            }
            level++;
        }
        return level;
    }

    // Driver code
    public static void main(String[] args) {
        String[] inputs =  {"4"};
        String[][] inputs1 = {{"1", "2"},{"0", "2", "3"},{"0", "1"},{"1"}};
        String[] inputs2 = {"0"};
        String[] inputs3 = {"3"};

        for(int i = 0; i < inputs.length; i++) {

            int n = Integer.parseInt(inputs[i]);
            Node[] nodes = new Node[n];
            for (int j = 0; j < n; j++) {
                nodes[j] = new Node(j);
            }
            Map<Node, List<Node>> graph = new HashMap<>(n);
            for (int j = 0; j < n; j++) {
                List<Node> neighbors = Arrays.stream(inputs1[j]).map(node -> nodes[Integer.parseInt(node)]).collect(Collectors.toList());
                graph.put(nodes[j], neighbors);
            }
            Node A = nodes[Integer.parseInt(inputs2[i])];
            Node B = nodes[Integer.parseInt(inputs3[i])];

            System.out.println("Length of shortest path : " + String.valueOf(getLengthOfShortestPath(graph, A, B)));
        }
    }
    static class Node {
        int val;

        public Node(int val) {
            this.val = val;
        }
    }
}
