package self.alg.sorting.topological_sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

// See wikipedia: https://en.wikipedia.org/wiki/Topological_sorting
// https://www.geeksforgeeks.org/topological-sorting/
// both samples are based on dfs
// https://www.personal.kent.edu/~rmuhamma/Algorithms/MyAlgorithms/GraphAlgor/topoSort.htm
// see why dfs just outputs vertices in topological reverse order
// there's path to be guaranteed with finish[x] < finish[y] if only if the graph is acyclic (a-cycle-lic)
// another reference https://takeuforward.org/data-structure/topological-sort-using-dfs/

public class Solution2DFS {
    static class Node {
        int name;
        HashSet<Node> adjacentNodes;

        Node(int name) {
            this.name = name;
            this.adjacentNodes = new HashSet<>();
        }

        void addNode(Node node) { // edge to another node
            this.adjacentNodes.add(node);
        }
    }

    static Stack<Node> topologicalSort(HashSet<Node> nodes) {;
        Stack<Node> stack = new Stack<>();
        boolean[] visited = new boolean[nodes.size()];
        boolean[] visiting = new boolean[nodes.size()];
        Arrays.fill(visiting, false);
        Arrays.fill(visited, false);

        for (Node n: nodes) {
            if (visited[n.name]) {
                continue;
            }

            helper(stack, nodes, n, visited, visiting);
        }

        return stack;
    }

    private static void helper(Stack<Node> stack, HashSet<Node> nodes, Node node, boolean visited[], boolean visiting[]) {
        visited[node.name] = true;

        visiting[node.name] = true;


        for (Node adj: node.adjacentNodes) {
            if (visited[adj.name]) {
                continue;
            }

            if (visiting[adj.name]) {
                throw new RuntimeException("cycle detected");
            }

            helper(stack, nodes, adj, visited, visiting);


        }

        stack.push(node); // outward case must put here, while inward case put after adj nodes iterations

        visiting[node.name] = false;
    }

    public static void main(String[] args) {
        // example of https://www.geeksforgeeks.org/topological-sorting/
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        HashSet<Node> nodes = new HashSet<>(Arrays.asList(node0, node1, node2, node3, node4, node5));

        node5.addNode(node0);
        node4.addNode(node0);
        node4.addNode(node1);
        node3.addNode(node1);
        node2.addNode(node3);
        node5.addNode(node2);

        Stack<Node> result = topologicalSort(nodes);
        while(!result.isEmpty()) {
            System.out.println("Item " + result.pop().name);
        }
    }
}
