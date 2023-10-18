package self.alg.sorting.topological_sort;

import java.util.*;

// A DAG G has at least one vertex with in-degree 0 and one vertex with out-degree 0.
public class Solution2BFSKahnOrInDegree {
    static class Node {

         int getName() {
            return this.name;
        }
        int name;
        List<Node> adjacentNodes = new ArrayList<>();

        Node(int name) {
            this.name = name;
        }

        void addNode(Node node) {
            this.adjacentNodes.add(node);
        }

    }

    static Queue<Node> topologicalUsingBFS(HashMap<Integer, Node> nodes) {
        int[] inDegreeCounts = new int[nodes.size()];
        Arrays.fill(inDegreeCounts, 0);
        for (Node n: nodes.values()) {
            for (Node adj: n.adjacentNodes) {
                inDegreeCounts[adj.name]++;
            }
        }

        Queue<Node> result = new LinkedList<>(); // used to print it later;
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < inDegreeCounts.length; i++) {
            if (inDegreeCounts[i] == 0) {
                queue.offer(nodes.get(i));
            }
        }

        int processedVertices = 0;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            result.offer(node);
            processedVertices++;

            for (Node adj: node.adjacentNodes) {
                inDegreeCounts[adj.name]--;

                if (inDegreeCounts[adj.name] == 0) {
                    queue.offer(nodes.get(adj.name));
                }
            }

            if (processedVertices > nodes.size()) {
                throw new RuntimeException("cycle detected");
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // example of https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);


        node5.addNode(node0);
        node4.addNode(node0);
        node4.addNode(node1);
        node3.addNode(node1);
        node2.addNode(node3);
        node2.addNode(node2);


        HashMap<Integer, Node> nodes = new HashMap<>();
        nodes.put(node0.name, node0);
        nodes.put(node1.name, node1);
        nodes.put(node2.name, node2);
        nodes.put(node3.name, node3);
        nodes.put(node4.name, node4);
        nodes.put(node5.name, node5);


        Queue<Node> result = topologicalUsingBFS(nodes);
        for (Node n: result) {
            System.out.println("Item " + n.name);
        }

    }
}
